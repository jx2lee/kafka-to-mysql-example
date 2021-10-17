package com.jx2lee.consumerv1;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class ConsumerApplication {
    private static int consumerCount = 10;
    private static List<ConsumerWorker> consumerWorkers = new ArrayList<>();

    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new ShutdownThread());
        Runtime.getRuntime().addShutdownHook(new ShutdownThread());

        Properties configs = new Properties();
        configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        configs.put(ConsumerConfig.GROUP_ID_CONFIG, "test");
        configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        configs.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < consumerCount; i++) {
            ConsumerWorker consumerWorker = new ConsumerWorker(configs, "events-all", i);
            consumerWorkers.add(consumerWorker);
            executorService.execute(consumerWorker);
        }
    }

    static class ShutdownThread extends Thread {
        public void run() {
            consumerWorkers.forEach(ConsumerWorker::shutdown);
            log.info("Bye..");
        }
    }
}
