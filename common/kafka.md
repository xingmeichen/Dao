# Kafka

## References
https://kafka.apache.org/quickstart

## start kafka: run below command in order
1. Start zookeeper service
sudo ${KAFKA_HOME}/bin/zookeeper-server-start.sh ${KAFKA_HOME}/config/zookeeper.properties
2. start kafka broker service
sudo ${KAFKA_HOME}/bin/kafka-server-start.sh ${KAFKA_HOME}/config/server.properties

## List topic
sudo ${KAFKA_HOME}/bin/kafka-topics.sh --list --bootstrap-server localhost:9092

## Create topic
sudo ${KAFKA_HOME}/bin/kafka-topics.sh --create --topic {topic_name} --bootstrap-server localhost:9092

## Produce message (if the topic is not there, topic will be created first and then produce message)
sudo ${KAFKA_HOME}/bin/kafka-console-producer.sh --topic {topic_name} --bootstrap-server localhost:9092

## Consume message (from beginning)
sudo ${KAFKA_HOME}/bin/kafka-console-consumer.sh --topic {topic_name} --from-beginning --bootstrap-server localhost:9092

## Stop zookeeper service / kafka broker service / Producer / Consumer
Ctrl-C