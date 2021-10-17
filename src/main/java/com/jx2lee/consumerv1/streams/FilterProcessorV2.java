package com.jx2lee.consumerv1.streams;

import com.google.gson.Gson;
import com.jx2lee.consumerv1.streams.domain.Customer;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.streams.kstream.ValueTransformer;
import org.apache.kafka.streams.kstream.ValueTransformerWithKey;
import org.apache.kafka.streams.processor.ProcessorContext;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class FilterProcessorV2 implements ValueTransformer<String, String> {
    private ProcessorContext context;

    @Override
    public void init(ProcessorContext context) {
        this.context = context;
    }

    // @Override
    // public String transform(String value) {
    //     List<String> valueList = Arrays.stream(value.split(",")).collect(Collectors.toList());
    //     return String.join(",", valueList.subList(1, valueList.size()));
    // }

    @Override
    public String transform(String value) {
        List<String> valueList = Arrays.stream(value.split(",")).collect(Collectors.toList());
        Customer customer = new Customer(valueList.get(0), valueList.get(1), valueList.get(2), valueList.get(3));

        Gson gson = new Gson();
        String s = gson.toJson(customer);
        log.info(s);
        return String.join(",", valueList.subList(1, valueList.size()));
    }

    @Override
    public void close() {

    }
}
