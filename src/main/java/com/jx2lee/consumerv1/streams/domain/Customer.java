package com.jx2lee.consumerv1.streams.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Customer {

    private String cstno;
    private String reg_dttm;
    private String cust_nm;
    private String rec_nm;

    public Customer(String cstno, String reg_dttm, String cust_nm, String rec_nm) {
        this.cstno = cstno;
        this.reg_dttm = reg_dttm;
        this.cust_nm = cust_nm;
        this.rec_nm = rec_nm;
    }


}
