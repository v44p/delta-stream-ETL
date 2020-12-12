cmd_run_stream(){
    spark-submit \
    --class main.scala.DeltaStreamEtl \
    --master "local[2]" \
    --packages io.delta:delta-core_2.12:0.7.0 \
    --conf "spark.sql.extensions=io.delta.sql.DeltaSparkSessionExtension" \
    --conf "spark.sql.catalog.spark_catalog=org.apache.spark.sql.delta.catalog.DeltaCatalog" \
    /home/vlad/project/aws-poc/sparkdeltaetl/target/scala-2.12/sparkDeltaEtl-assembly-0.0.1.jar \
    /tmp/delta-table \
    /tmp/checkpoint/delta-etl 
}

case "$1" in
    run)
        shift
        cmd_run_stream "$@"
        ;;
esac