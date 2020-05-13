package com.example.covid19.model;

public class mesg {
    public String user;
    public String disg;
    public String msg;

    public mesg() {
    }

    public mesg(String user, String disg, String msg) {
        this.user = user;
        this.disg = disg;
        this.msg = msg;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDisg() {
        return disg;
    }

    public void setDisg(String disg) {
        this.disg = disg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
