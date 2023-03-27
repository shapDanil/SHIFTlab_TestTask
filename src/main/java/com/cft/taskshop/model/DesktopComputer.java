package com.cft.taskshop.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "desktopComputers")
public class DesktopComputer extends Сommodity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String formFactor;

    public DesktopComputer(String serialNumber, String producer, int price, int amount, Integer id, String formFactor) {
        super(serialNumber, producer, price, amount);
        this.id = id;
        this.formFactor = formFactor;
    }

    public DesktopComputer() {
        super();
        formFactor = "Desktop";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFormFactor() {
        return formFactor;
    }

    public void setFormFactor(String formFactor) {
        this.formFactor = formFactor;
    }
}
