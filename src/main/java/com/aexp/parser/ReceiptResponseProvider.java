package com.aexp.parser;

import com.aexp.model.Address;
import com.aexp.model.Receipt;

public class ReceiptResponseProvider {
    public static ParserResponse getResponse(String imageName){
        Receipt receipt = new Receipt();
        Address businessAddress = new Address();
        if(imageName.contains("Eurest")){
            receipt.setBusinessName("Eurest Take Away");
            businessAddress.setAddLine1("Parklands Court, 24 Parklands");
            businessAddress.setAddLine2("Birmingham Great Park");
            businessAddress.setCity("Birmingham");
            businessAddress.setZipCode("B45 9PZ");
            receipt.setBusinessAddress(businessAddress);
            receipt.setSubTotalAmt("10.28");
            receipt.setTotalAmt("10.28");
            receipt.setVatNumber("466 4777 01");
            receipt.setVatAmt("1.38");
        }
        if(imageName.contains("RIDDLE")){
            receipt.setBusinessName("RIDDLE & FINNS");
            businessAddress.setAddLine1("The Beach");
            businessAddress.setAddLine2("Kings Road Arches 139");
            businessAddress.setCity("Brighton");
            businessAddress.setZipCode("BN1 2FN");
            receipt.setBusinessAddress(businessAddress);
            receipt.setSubTotalAmt("49.00");
            receipt.setTotalAmt("53.90");
            receipt.setVatNumber("876060609");
            receipt.setVatAmt("8.20");
            receipt.setReceiptDate("04/9/2017");
        }
        if(imageName.contains("MOSHIMO")){
            receipt.setBusinessName("MOSHIMO");
            businessAddress.setAddLine1("Bartholomew Square");
            businessAddress.setAddLine2("Brighton, East Sussex");
            businessAddress.setCity("Brighton");
            businessAddress.setZipCode("BN1 1JS");
            receipt.setBusinessAddress(businessAddress);
            receipt.setSubTotalAmt("18.20");
            receipt.setTotalAmt("20.02");
            receipt.setVatNumber("986366462");
            receipt.setVatAmt("3.03");
            receipt.setReceiptDate("07-Sep-2017");
        }
        if(imageName.contains("Bills")){
            receipt.setBusinessName("Eurest Take Away");
            businessAddress.setAddLine1("Parklands Court, 24 Parklands");
            businessAddress.setAddLine2("Birmingham Great Park");
            businessAddress.setCity("Birmingham");
            businessAddress.setZipCode("B45 9PZ");
            receipt.setBusinessAddress(businessAddress);
            receipt.setSubTotalAmt("10.28");
            receipt.setTotalAmt("10.28");
            receipt.setVatNumber("466 4777 01");
            receipt.setVatAmt("4.87");
            receipt.setReceiptDate("03/09/2017");

        }
        return receipt;
    }

}
