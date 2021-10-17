package com.jx2lee.consumerv1.streams.domain.table;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Accounts {
    private String cstno;
    private String cust_nm;
    private String rec_nm;
    private String sex_cd;
    private String birth;

    public Accounts(String cstno, String cust_nm, String rec_nm, String sex_cd, String birth) {
        this.cstno = cstno;
        this.cust_nm = cust_nm;
        this.rec_nm = rec_nm;
        this.sex_cd = sex_cd;
        this.birth = birth;
    }
}
