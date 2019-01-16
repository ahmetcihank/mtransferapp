package com.sft.Modals;

/**
 * Created by SOFTWARE02 on 16.01.2019.
 */
public class Account {
    int accountid =0;
    String loginame ="";
    int balance =0;

    public Account(int accountid, String loginame, int balance) {
        this.accountid = accountid;
        this.loginame = loginame;
        this.balance = balance;
    }

    public Account(){}

    public int getAccountid() {
        return accountid;
    }

    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }

    public String getLoginame() {
        return loginame;
    }

    public void setLoginame(String loginame) {
        this.loginame = loginame;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
