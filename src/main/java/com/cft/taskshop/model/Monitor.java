package com.cft.taskshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "monitor")
public class Monitor extends Сommodity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer diagonal;
    public Monitor(String serialNumber, String manufacturer, int price, int amount, Integer id, Integer diagonal) {
        super(serialNumber, manufacturer, price, amount);
        this.id = id;
        this.diagonal = diagonal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(Integer diagonal) {
        this.diagonal = diagonal;
    }

    public Monitor() {
        super();
        diagonal = 0;
    }
}
