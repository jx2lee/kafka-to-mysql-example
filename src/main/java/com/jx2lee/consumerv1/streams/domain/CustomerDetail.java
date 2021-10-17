package com.jx2lee.consumerv1.streams.domain;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter @Setter
public class CustomerDetail {
    private String cstno;
    private Timestamp reg_dttm;
    private String sex_cd;
    private String birth;

    public CustomerDetail(String cstno, Timestamp reg_dttm, String sex_cd, String birth) {
        this.cstno = cstno;
        this.reg_dttm = reg_dttm;
        this.sex_cd = sex_cd;
        this.birth = birth;
    }

}
