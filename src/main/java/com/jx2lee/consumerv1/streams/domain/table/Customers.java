package com.jx2lee.consumerv1.streams.domain.table;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
public class Customers {
    private String cstno;
    private String cust_nm;
    private String rec_nm;
    private String sex_cd;
    private String birth;

    public Customers(String cstno, String cust_nm, String rec_nm, String sex_cd, String birth) {
        this.cstno = cstno;
        this.cust_nm = cust_nm;
        this.rec_nm = rec_nm;
        this.sex_cd = sex_cd;
        this.birth = birth;
    }

}
