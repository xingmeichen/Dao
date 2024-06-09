package com.dao.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * @project: Dao
 * @description:
 * @author: Mabel.Chen
 * @create: 2024-06-07
 **/
public class DaoProducer {

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty("", ""); // server
        properties.setProperty("", ""); // key serialize
        properties.setProperty("", ""); // value serialize
        Producer producer = new KafkaProducer(properties);

        // topic, value
        ProducerRecord record = new ProducerRecord("First", "One try");
        producer.send(record);
        producer.close();
    }
}