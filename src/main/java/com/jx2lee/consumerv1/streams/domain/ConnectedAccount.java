package com.jx2lee.consumerv1.streams.domain;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter @Setter
public class ConnectedAccount {
    private String acno;
    private Timestamp reg_dttm;
    private String link_acno;

    public ConnectedAccount(String acno, Timestamp reg_dttm, String link_acno) {
        this.acno = acno;
        this.reg_dttm = reg_dttm;
        this.link_acno = link_acno;
    }
}
