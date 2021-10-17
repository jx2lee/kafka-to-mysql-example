package com.jx2lee.consumerv1.streams.domain;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter @Setter
public class TransactionATM {

    private String acno;
    private int seqno;
    private Timestamp reg_dttm;
    private String atm_cd;

    public TransactionATM(String acno, int seqno, Timestamp reg_dttm, String atm_cd) {
        this.acno = acno;
        this.seqno = seqno;
        this.reg_dttm = reg_dttm;
        this.atm_cd = atm_cd;
    }
}
