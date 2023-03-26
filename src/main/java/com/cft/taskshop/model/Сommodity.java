package com.cft.taskshop.model;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Сommodity {
    private String serialNumber;
    private String manufacturer;
    private int price;
    private int amount;

    public Сommodity(String serialNumber, String manufacturer, int price, int amount) {
        this.serialNumber = serialNumber;
        this.manufacturer = manufacturer;
        this.price = price;
        this.amount = amount;
    }
    public Сommodity() {
        this.serialNumber = "Unknown!";
        this.manufacturer = "Unknown!";
        this.price = 0;
        this.amount = 0;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


}
