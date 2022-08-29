package com.example.pagaassgn;

import com.sun.istack.NotNull;

import javax.validation.constraints.NotBlank;

public class AddBinRequest {

    @NotNull
    @NotBlank
    private String content;

    private Integer expiry;

    public AddBinRequest(String content, Integer expiry) {
        this.content = content;
        this.expiry = expiry;
    }

    public AddBinRequest() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getExpiry() {
        return expiry;
    }

    public void setExpiry(Integer expiry) {
        this.expiry = expiry;
    }
}
