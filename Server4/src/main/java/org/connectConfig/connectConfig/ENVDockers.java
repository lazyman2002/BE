package org.connectConfig;

public class ENVDockers {
    // Open port
    public static final int gRPC_port = 50051;

    // Hadoop nodes
    public static final String hadoop_master1_name = "hadoop-master1";
    public static final String hadoop_master1_ip = "172.18.0.2";

    public static final String hadoop_slave1_name = "hadoop-slave1";
    public static final String hadoop_slave1_ip = "172.18.0.3";

    public static final String hadoop_slave2_name = "hadoop-slave2";
    public static final String hadoop_slave2_ip = "172.18.0.4";

    public static final String hadoop_slave3_name = "hadoop-slave3";
    public static final String hadoop_slave3_ip = "172.18.0.5";

    // Spark nodes
    public static final String spark_master1_name = "spark-master1";
    public static final String spark_master1_ip = "172.18.0.6";

    public static final String spark_worker1_name = "spark-worker1";
    public static final String spark_worker1_ip = "localhost";

    public static final String spark_worker2_name = "spark-worker2";
    public static final String spark_worker2_ip = "172.18.0.8";

    public static final String spark_worker3_name = "spark-worker3";
    public static final String spark_worker3_ip = "172.18.0.9";

    // Zookeeper node
    public static final String zoo_name = "zoo";
    public static final String zoo_ip = "172.18.0.10";

    // HBase nodes
    public static final String hbase_master_name = "hbase-master";
    public static final String hbase_master_ip = "172.18.0.11";

    // Kafka nodes
    public static final String kafka_node1_name = "kafka-node1";
    public static final String kafka_node1_ip = "172.18.0.12";

    public static final String kafka_node2_name = "kafka-node2";
    public static final String kafka_node2_ip = "172.18.0.13";

    public static final String kafka_node3_name = "kafka-node3";
    public static final String kafka_node3_ip = "172.18.0.14";
}
