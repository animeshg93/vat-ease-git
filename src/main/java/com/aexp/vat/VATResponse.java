package com.aexp.vat;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class VATResponse {
    private boolean success;
    private String code;
    private VATInfo data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public VATInfo getData() {
        return data;
    }

    public void setData(VATInfo data) {
        this.data = data;
    }

}
