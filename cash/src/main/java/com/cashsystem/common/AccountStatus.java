package com.cashsystem.common;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum AccountStatus {
    UnLock(1,"启用"),Lock(2,"启停");

    private int flg;
    private String desc;

    public int getFlg() {
        return flg;
    }

    public String getDesc() {
        return desc;
    }

    AccountStatus(int flg, String desc) {
        this.flg = flg;
        this.desc = desc;
    }

    public static AccountStatus valueOf(int flg) {
        for(AccountStatus accountStatus:values()) {
            if (accountStatus.flg==flg) {
                return accountStatus;
            }
        }
        throw new RuntimeException("orderStatus flg"
                + flg + "not fount!");
    }
}
