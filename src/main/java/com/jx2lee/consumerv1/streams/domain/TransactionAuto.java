package com.jx2lee.consumerv1.streams.domain;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter @Setter
public class TransactionAuto {

    private String acno;
    private int seqno;
    private Timestamp reg_dttm;
    private String auto_cycl;

    public TransactionAuto(String acno, int seqno, Timestamp reg_dttm, String auto_cycl) {
        this.acno = acno;
        this.seqno = seqno;
        this.reg_dttm = reg_dttm;
        this.auto_cycl = auto_cycl;
    }
}
