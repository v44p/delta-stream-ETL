package main.scala

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.streaming.StreamingQuery
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.DataFrame


object ETLProcess {
  def readFromRate(spark: SparkSession): DataFrame = {
    spark
      .readStream
      .format("rate")
      .load()
  }
}
