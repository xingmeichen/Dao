package com.dao.kafka;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.TopicPartition;

import java.time.Duration;
import java.time.temporal.TemporalUnit;
import java.util.Collections;
import java.util.Map;
import java.util.Properties;

/**
 * @project: Dao
 * @description:
 * @author: Mabel.Chen
 * @create: 2024-06-07
 **/
public class DaoConsumer {

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty("", ""); // server;
        properties.setProperty("", ""); // key deserilize;
        properties.setProperty("", ""); // value deserilize;
        Consumer consumer = new KafkaConsumer(properties);

        consumer.subscribe(Collections.singletonList("First"));

        Duration duration = Duration.ofSeconds(50);
        while (true) {
            ConsumerRecords records = consumer.poll(duration);
            consumer.commitAsync();
            consumer.commitAsync(new OffsetCommitCallback() {
                @Override
                public void onComplete(Map<TopicPartition, OffsetAndMetadata> map, Exception e) {
                    // TODO
                }
            });
        }

    }
}