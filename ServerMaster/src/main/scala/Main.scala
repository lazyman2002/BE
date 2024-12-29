import org.apache.hadoop.hbase.spark.datasources.HBaseTableCatalog
import org.apache.spark.sql.functions._
import org.apache.spark.sql.streaming.Trigger
import org.apache.spark.sql.{DataFrame, SparkSession}

import spark.Spark._

object Main {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
            .appName("1")
            .master("local[*]")
            .getOrCreate()
    MessageRead(spark)
  }
  
  private def MessageRead (spark : SparkSession) : Unit ={
    val kafkaStream = spark
            .readStream
            .format("kafka")
            .option("kafka.bootstrap.servers", "172.18.0.2:9092,172.18.0.3:9092,172.18.0.4:9092")
            .option("subscribe", "Message")
            .option("startingOffsets", "latest")
            .load()
    
    val valueStream = kafkaStream.selectExpr("CAST(value AS STRING)")
    
    import org.apache.spark.sql.types._
    val schema = StructType(Seq(
      StructField("msgID", IntegerType, nullable = false),
      StructField("fromUserID", IntegerType, nullable = false),
      StructField("toGroupID", IntegerType, nullable = false),
      StructField("messengerData", StringType, nullable = false),
      StructField("createdAt", StringType, nullable = false),
      StructField("deletedAt", StringType, nullable = true)
    ))
    
    val messengerDF = valueStream
            .withColumn("jsonData", from_json(col("value"), schema))
            .select("jsonData.*")
            .withColumn("myRowID", col("toGroupID") + "-" + col("msgID"));
    
    val hbaseCatalog =
      s"""
         |{
         |  "table":{"namespace":"default", "name":"messengers"},
         |  "rowkey":"myRowID",
         |  "columns":{
		 |    "myRowID":{"cf":"rowkey", "col":"myRowID", "type":"string"}
         |    "msgID":{"cf":"data", "col":"msgID", "type":"int"},
         |    "fromUserID":{"cf":"data", "col":"fromUserID", "type":"int"},
         |    "toGroupID":{"cf":"data", "col":"toGroupID", "type":"int"},
         |    "messengerData":{"cf":"data", "col":"messengerData", "type":"string"},
         |    "createdAt":{"cf":"data", "col":"createdAt", "type":"string"},
         |    "deletedAt":{"cf":"data", "col":"deletedAt", "type":"string"}
         |  }
         |}
         |""".stripMargin
    
    messengerDF.writeStream
            .foreachBatch { (batchDF: DataFrame, _: Long) =>
              batchDF.write
                      .option(HBaseTableCatalog.tableCatalog, hbaseCatalog)
                      .option(HBaseTableCatalog.newTable, "MSG")
                      .format("org.apache.hadoop.hbase.spark")
                      .save()
            }
            .outputMode("append")
            .trigger(Trigger.ProcessingTime("10 seconds"))
            .start()
            .awaitTermination()
  }
  

}

