package com.exchange.rest.models;

/**
 * Created by Moroi Andrian on 3/14/14.
 */
public class JCourseValue {

    private String courseCode;
    private String bankName;
    private Float purchaseValue;
    private Float saleValue;


    public Float getPurchaseValue() {
        return purchaseValue;
    }

    public void setPurchaseValue(Float purchaseValue) {
        this.purchaseValue = purchaseValue;
    }

    public Float getSaleValue() {
        return saleValue;
    }

    public void setSaleValue(Float saleValue) {
        this.saleValue = saleValue;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}
