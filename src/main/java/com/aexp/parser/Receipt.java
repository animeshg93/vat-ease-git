package com.aexp.parser;

public class Receipt implements ParserResponse{
    private String businessName;
    private Address businessAddress;
    private String vatNumber;
    private String receiptDate;
    private String subTotalAmt;
    private String vatAmt;
    private String totalAmt;

    public Address getBusinessAddress() {
        return businessAddress;
    }

    public void setBusinessAddress(Address businessAddress) {
        this.businessAddress = businessAddress;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }



    public String getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    public String getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(String receiptDate) {
        this.receiptDate = receiptDate;
    }

    public String getSubTotalAmt() {
        return subTotalAmt;
    }

    public void setSubTotalAmt(String subTotalAmt) {
        this.subTotalAmt = subTotalAmt;
    }

    public String getVatAmt() {
        return vatAmt;
    }

    public void setVatAmt(String vatAmt) {
        this.vatAmt = vatAmt;
    }

    public String getTotalAmt() {
        return totalAmt;
    }

    public void setTotalAmt(String totalAmt) {
        this.totalAmt = totalAmt;
    }
}
