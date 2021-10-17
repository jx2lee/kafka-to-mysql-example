package com.jx2lee.consumerv1.streams.domain;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter @Setter
public class Transaction {
    private String acno;
    private int seqno;
    private Timestamp reg_dttm;
    private String tx_chnl;
    private int after_bal;

    public Transaction(String acno, int seqno, Timestamp reg_dttm, String tx_chnl, int after_bal) {
        this.acno = acno;
        this.seqno = seqno;
        this.reg_dttm = reg_dttm;
        this.tx_chnl = tx_chnl;
        this.after_bal = after_bal;
    }
}
