package com.cft.taskshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "HDD")
public class HDD extends Сommodity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer memoryCapacityGB;

    public HDD(String serialNumber, String manufacturer, int price, int amount, Integer id, Integer memoryCapacityGB) {
        super(serialNumber, manufacturer, price, amount);
        this.id = id;
        this.memoryCapacityGB = memoryCapacityGB;
    }
    public HDD() {
        super();
        memoryCapacityGB = 0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMemoryCapacityGB() {
        return memoryCapacityGB;
    }

    public void setMemoryCapacityGB(Integer memoryCapacityGB) {
        this.memoryCapacityGB = memoryCapacityGB;
    }
}
