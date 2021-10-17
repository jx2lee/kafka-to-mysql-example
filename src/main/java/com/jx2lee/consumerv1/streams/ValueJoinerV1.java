package com.jx2lee.consumerv1.streams;

import com.jx2lee.consumerv1.streams.domain.Customer;
import com.jx2lee.consumerv1.streams.domain.CustomerDetail;
import com.jx2lee.consumerv1.streams.domain.table.Customers;

public class ValueJoinerV1 implements org.apache.kafka.streams.kstream.ValueJoiner<Customer, CustomerDetail, Customers> {

    @Override
    public Customers apply(Customer customer, CustomerDetail customerDetail) {
        return Customers.builder()
                .cstno(customer.getCstno())
                .cust_nm(customer.getCust_nm())
                .rec_nm(customer.getRec_nm())
                .sex_cd(customerDetail.getSex_cd())
                .birth(customerDetail.getBirth())
                .build();
    }
}
