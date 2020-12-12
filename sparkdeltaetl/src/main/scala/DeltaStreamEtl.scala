package main.scala

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.streaming.Trigger

object DeltaStreamEtl extends App{
  val (outputFile, checkpointFile) = (args(0),args(1))
  val spark = SparkSession.builder
    .appName("sparkDeltaEtl")
    .getOrCreate
  
    val rateStream = ETLProcess.readFromRate(spark)
    rateStream
      .writeStream
      .format("delta")
      .trigger(Trigger.ProcessingTime("30 seconds"))
      .option("checkpointLocation", checkpointFile)
      .start(outputFile)
      .awaitTermination()
}
