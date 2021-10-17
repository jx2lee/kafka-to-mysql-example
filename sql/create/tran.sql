create table tran (
    acno varchar(10) not null,
    seqno int(10) not null,
    reg_dttm DATETIME,
    tx_chnl varchar(10),
    after_bal int(10),
    atm_cd varchar(10),
    recv_nm varchar(20),
    auto_cycl varchar(10),
    primary key (acno, seqno)
)
