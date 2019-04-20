package com.example.a74104.clothesmatch.HaoYou;

public class Message {
    private String mes;
    private int TYPE; //1自己发送 2:别人发送

    public String getMes() {
        return mes;
    }

    public int getTYPE() {
        return TYPE;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public void setTYPE(int TYPE) {
        this.TYPE = TYPE;
    }
    public Message(){
        super();
    }
}
