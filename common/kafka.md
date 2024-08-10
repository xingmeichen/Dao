# Kafka

## start kafka: run below command in order
1. ${KAFKA_HOME}/bin/zookeeper-server-start.sh ${KAFKA_HOME}/config/zookeeper.properties
2. ${KAFKA_HOME}/bin/kafka-server-start.sh ${KAFKA_HOME}/config/server.properties

## List topic
${KAFKA_HOME}/bin/kafka-topics.sh --list --bootstrap-server localhost:9092

## Produce message (if the topic is not there, topic will be created first and then produce message)
${KAFKA_HOME}/bin/kafka-console-producer.sh --topic {topic_name} --bootstrap-server localhost:9092

## Consume message (from beginning)
${KAFKA_HOME}/bin/kafka-console-consumer.sh --topic {topic_name} --from-beginning --bootstrap-server localhost:9092

