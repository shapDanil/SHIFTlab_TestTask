package com.cft.taskshop.service.impl;


import com.cft.taskshop.model.Laptop;
import com.cft.taskshop.model.Monitor;
import com.cft.taskshop.repository.LaptopRepository;
import com.cft.taskshop.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaptopServiceImpl implements CommodityService<Laptop> {
    public LaptopRepository laptopRepository;

    @Autowired
    public LaptopServiceImpl(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }


    @Override
    public Laptop create(Laptop laptop) {
        return laptopRepository.save(laptop);
    }

    @Override
    public Laptop update(Laptop laptop, Integer id) {
        laptop.setId(id);
        return laptopRepository.save(laptop);
    }

    @Override
    public List<Laptop> getAll() {
        return laptopRepository.findAll();
    }

    @Override
    public Laptop get(int id) {
        return laptopRepository.findById(id).orElseThrow();
    }

}
