import JsonProtoParser.parseUserMetaInfo
import akka.actor.ActorSystem
import akka.grpc.GrpcClientSettings
import akka.stream.Materializer
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.col
import org.apache.spark.sql.streaming.Trigger
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}
import proto.{UserMetaInfo, UserServiceClient}

import scala.concurrent.{Await, ExecutionContext}
import scala.util.{Failure, Success}
object Main {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
            .appName("1")
            .master("local[*]")
            .getOrCreate()
    RequestCandidateRead(spark);
  }
  
  private def RequestCandidateRead (spark : SparkSession) : Unit ={
    var kafkaStream = spark
            .readStream
            .format("kafka")
            .option("kafka.bootstrap.servers", "172.18.0.2:9092,172.18.0.3:9092,172.18.0.4:9092")
            .option("subscribe", "Request.CandidateRead")
            .option("startingOffsets", "latest")
            .load()
    
    val valueStream = kafkaStream.selectExpr("CAST(value AS STRING)")
    
    implicit val system: ActorSystem = ActorSystem("AkkaGrpcClientSystem")
    implicit val materializer: Materializer = Materializer(system)
    implicit val ec: ExecutionContext = system.dispatcher
    
    val clientSettings: GrpcClientSettings = GrpcClientSettings.connectToServiceAt("172.18.0.6", 50051).withTls(false)
    val grpcClient = UserServiceClient(clientSettings);
    
    val sendToGrpc = valueStream.writeStream.foreachBatch { (batchDF, batchId) =>
      batchDF.collect().foreach { row =>
        val value = row.getAs[String]("value")
        
        val userMetaInfo = parseUserMetaInfo(value)
        
        grpcClient.candidateRead(userMetaInfo).onComplete {
          case Success(response) =>
            println(s"gRPC server replied: ${response.getUser.email}")
          case Failure(exception) =>
            println(s"Failed to send gRPC request: ${exception.getMessage}")
        }
      }
    }.start()
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

