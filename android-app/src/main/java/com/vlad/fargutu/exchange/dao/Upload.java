package com.vlad.fargutu.exchange.dao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 

/**
 * Entity mapped to table UPLOAD.
 */
public class Upload {

    private Long id;
    private String text;

    public Upload() {
    }

    public Upload(Long id) {
        this.id = id;
    }

    public Upload(Long id, String text) {
        this.id = id;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
