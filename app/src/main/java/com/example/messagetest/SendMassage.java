package com.example.messagetest;

import com.google.gson.annotations.SerializedName;

public class SendMassage {
    @SerializedName("phone")
    private String phone;
    @SerializedName("body")
    private String body;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
