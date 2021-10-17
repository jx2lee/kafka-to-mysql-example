package com.jx2lee.consumerv1;

import com.google.gson.JsonElement;
import com.jx2lee.consumerv1.mysql.MysqlConnector;
import com.jx2lee.consumerv1.streams.FilterProcessorV3;
import com.jx2lee.consumerv1.streams.ValueJoinerV1;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.*;

import java.util.Properties;

@Slf4j
public class ConsumerWorker implements Runnable{

    private Properties properties;
    private String topic;
    private String thread;
    // KafkaConsumer<String, String> consumer;
    KafkaStreams consumer_test;

    private MysqlConnector mysqlConnector;

    public ConsumerWorker(Properties properties, String topic, int number) {
        this.properties = properties;
        this.topic = topic;
        this.thread = "consumer-thread-" + number;
    }

    // @Override
    // public void run() {
    //     consumer = new KafkaConsumer<>(properties);
    //     consumer.subscribe(Arrays.asList(topic));
    //
    //     mysqlConnector = new MysqlConnector();
    //     mysqlConnector.connect();
    //     try {
    //
    //         while (true) {
    //             ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(1));
    //
    //             for (ConsumerRecord<String, String> record : records) {
    //                 // String[] values = record.value().split(",");
    //                 // String logType = values[0];
    //                 // if (logType.equalsIgnoreCase("고객")) {
    //                 //     System.out.println(record.value());
    //                 // }
    //                 System.out.println("record = " + record);
    //             }
    //             consumer.commitSync();
    //         }
    //     } catch (WakeupException e ) {
    //     } finally {
    //         consumer.commitSync();
    //         consumer.close();
    //
    //         mysqlConnector.disconnect();
    //     }
    // }

    @Override
    public void run() {
        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "t1");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());

        final StreamsBuilder streamsBuilder = new StreamsBuilder();

        KStream<String, String> eventsAllTopic = streamsBuilder.stream("events-all");
        KStream<String, JsonElement> customer = eventsAllTopic.filter(getCustomerInfo("고객"))
                .selectKey(setKey())
                .transformValues(() -> new FilterProcessorV3());

        KStream<String, JsonElement> customerDetail = eventsAllTopic.filter(getCustomerInfo("고객상세"))
                .selectKey(setKey())
                .transformValues(() -> new FilterProcessorV3());

        KafkaStreams streams = new KafkaStreams(streamsBuilder.build(), props);

        streams.start();
    }

    private Predicate<String, String> getCustomerInfo(String table) {
        return (key, value) -> value.split(",")[0].equalsIgnoreCase(table);
    }

    private KeyValueMapper<String, String, String> setKey() {
        return (key, value) -> value.split(",")[1];
    }

    public void shutdown() {
        // consumer.wakeup();
        consumer_test.close();
    }
}
