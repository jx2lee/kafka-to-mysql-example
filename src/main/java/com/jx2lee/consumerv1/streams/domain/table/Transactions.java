package com.jx2lee.consumerv1.streams.domain.table;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Transactions {
    private String acno;
    private int seqno;
    private String reg_dttm;
    private String tx_chnl;
    private int after_bal;
    private String atm_cd;
    private String recv_nm;
    private String auto_cycl;

    public Transactions(String acno, int seqno, String reg_dttm, String tx_chnl, int after_bal, String atm_cd, String recv_nm, String auto_cycl) {
        this.acno = acno;
        this.seqno = seqno;
        this.reg_dttm = reg_dttm;
        this.tx_chnl = tx_chnl;
        this.after_bal = after_bal;
        this.atm_cd = atm_cd;
        this.recv_nm = recv_nm;
        this.auto_cycl = auto_cycl;
    }
}
