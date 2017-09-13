/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.rest.pojo;

/**
 *
 * @author user
 */
public class Product {

    private String uid;
    private String name;
    private String src;
    private String info;
    private Double price;

    public Product(String uid, String name, String src, String info, Double price) {
        this.uid = uid;
        this.name = name;
        this.src = src;
        this.info = info;
        this.price = price;
    }

    /**
     * @return the id
     */
    public String getUid() {
        return uid;
    }

    /**
     * @param id the id to set
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the src
     */
    public String getSrc() {
        return src;
    }

    /**
     * @param src the src to set
     */
    public void setSrc(String src) {
        this.src = src;
    }

    /**
     * @return the info
     */
    public String getInfo() {
        return info;
    }

    /**
     * @param info the info to set
     */
    public void setInfo(String info) {
        this.info = info;
    }

    /**
     * @return the price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(Double price) {
        this.price = price;
    }

}
