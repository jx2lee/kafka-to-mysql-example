package com.jx2lee.consumerv1.streams.domain;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter @Setter
public class Account {

    private String acno;
    private Timestamp reg_dttm;
    private String cstno;
    private String gds_nm;

    public Account(String acno, Timestamp reg_dttm, String cstno, String gds_nm) {
        this.acno = acno;
        this.reg_dttm = reg_dttm;
        this.cstno = cstno;
        this.gds_nm = gds_nm;
    }
}
