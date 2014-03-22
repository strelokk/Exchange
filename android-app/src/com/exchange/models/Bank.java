package com.exchange.models;

import java.util.List;

/**
 * Created by vlad.fargutu on 3/20/14.
 */
public class Bank {

    private String bankName;
    private Float purchase;
    private Float sale;
    private List<Branch> branchs;

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Float getPurchase() {
        return purchase;
    }

    public void setPurchase(Float purchase) {
        this.purchase = purchase;
    }

    public Float getSale() {
        return sale;
    }

    public void setSale(Float sale) {
        this.sale = sale;
    }

    public List<Branch> getBranchs() {
        return branchs;
    }

    public void setBranchs(List<Branch> branchs) {
        this.branchs = branchs;
    }

}
