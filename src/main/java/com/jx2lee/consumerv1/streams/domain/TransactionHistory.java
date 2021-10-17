package com.jx2lee.consumerv1.streams.domain;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter @Setter
public class TransactionHistory {

    private String acno;
    private int seqno;
    private Timestamp reg_dttm;
    private String recv_nm;

    public TransactionHistory(String acno, int seqno, Timestamp reg_dttm, String recv_nm) {
        this.acno = acno;
        this.seqno = seqno;
        this.reg_dttm = reg_dttm;
        this.recv_nm = recv_nm;
    }
}
