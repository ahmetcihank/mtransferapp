package com.sft.Modals;

/**
 * Created by SOFTWARE02 on 14.01.2019.
 */
public class Person {
    private String loginname ="";
    private String username = "";
    private String email ="";

    public Person(String loginname, String username, String email) {
        this.loginname = loginname;
        this.username = username;
        this.email = email;
    }

    public Person(){}


    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
