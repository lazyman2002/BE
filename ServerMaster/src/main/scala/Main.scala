import akka.actor.ActorSystem
import akka.grpc.GrpcClientSettings
import org.apache.hadoop.shaded.com.google.gson.{Gson, GsonBuilder}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}
import proto.{UserMetaInfo, UserServiceClient}

import scala.concurrent.Await
import scala.concurrent.duration._

object Main {
  
  val gson : Gson = new GsonBuilder().setPrettyPrinting().create()
  def main(args: Array[String]): Unit = {
//    val spark = SparkSession.builder()
//            .appName("Logger")
//            .master("yarn")
//            .getOrCreate()
//    val schema = messageSchema;
//
//    RequestCandidateRead(spark)
    
    implicit val system: ActorSystem = ActorSystem("AkkaGrpcClientSystem")
    implicit val ec = system.dispatcher;
    
    val clientSettings: GrpcClientSettings = GrpcClientSettings.connectToServiceAt("localhost", 50051).withTls(false)
    
    val client: UserServiceClient = UserServiceClient(clientSettings)
    
    val responseFuture = client.userRead(UserMetaInfo(userID = 1));
    
    responseFuture.onComplete { response =>
      println(s"Server responded: ${response.get.username}")
      system.terminate()
    }
    
    Await.result(system.whenTerminated, Duration.Inf)
  }
  
  private def RequestCandidateRead (spark : SparkSession) : Unit ={
    var RequestCandidateRead = spark
            .readStream
            .format("kafka")
            .option("kafka.bootstrap.servers", "172.18.0.2:9092,172.18.0.3:9092,172.18.0.4:9092")
            .option("subscribe", "Request.CandidateRead")
            .option("startingOffsets", "latest")
            .load()
    
    val valueStream = RequestCandidateRead.selectExpr("CAST(value AS STRING) as value")
    
    val query = valueStream.writeStream
            .outputMode("append") // Ghi ra từng bản ghi khi có dữ liệu mới
            .format("console") // Hiển thị trên console
            .start()
  }
  
  val userSchema = StructType(Seq(
    StructField("id", StringType, nullable = true),
    StructField("name", StringType, nullable = true),
    StructField("email", StringType, nullable = true),
    StructField("age", IntegerType, nullable = true)
  ))
  
  val messageSchema = StructType(Seq(
    StructField("key", StringType, nullable = true),
    StructField("value", StringType, nullable = true)
  ))
  
  def makeTopic(spark : SparkSession):Unit = {
    //Request
    
    //Response
    return;
  }
}

