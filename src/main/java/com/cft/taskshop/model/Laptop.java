package com.cft.taskshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "laptop")
public class Laptop extends Сommodity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer laptopSizeInInches;

    public Laptop(String serialNumber, String manufacturer, int price, int amount, Integer id, Integer laptopSizeInInches) {
        super(serialNumber, manufacturer, price, amount);
        this.id = id;
        this.laptopSizeInInches = laptopSizeInInches;
    }
    public Laptop() {
        super();
        laptopSizeInInches = 0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLaptopSizeInInches() {
        return laptopSizeInInches;
    }

    public void setLaptopSizeInInches(Integer laptopSizeInInches) {
        this.laptopSizeInInches = laptopSizeInInches;
    }

}
