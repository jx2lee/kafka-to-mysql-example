package com.jx2lee.consumerv1.streams;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.jx2lee.consumerv1.streams.domain.Customer;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.streams.kstream.ValueTransformerWithKey;
import org.apache.kafka.streams.processor.ProcessorContext;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class FilterProcessorV3 implements ValueTransformerWithKey<String, String, JsonElement> {
    @Override
    public void init(ProcessorContext context) {

    }

    @Override
    public JsonElement transform(String key, String value) {
        List<String> valueList = Arrays.stream(value.split(",")).collect(Collectors.toList());
        Customer customer = new Customer(valueList.get(0), valueList.get(1), valueList.get(2), valueList.get(3));

        Gson gson = new Gson();
        String s = gson.toJson(customer);

        JsonElement jsonElement = JsonParser.parseString(s);
        log.info(jsonElement.toString());
        return jsonElement;
    }

    @Override
    public void close() {

    }
}
