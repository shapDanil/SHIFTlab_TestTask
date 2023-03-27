package com.cft.taskshop.service.impl;

import com.cft.taskshop.model.HDD;
import com.cft.taskshop.repository.HDDRepository;
import com.cft.taskshop.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HDDServiceImpl implements CommodityService<HDD> {
    public HDDRepository hddRepository;

    @Autowired
    public HDDServiceImpl(HDDRepository hddRepository) {
        this.hddRepository = hddRepository;
    }

    @Override
    public HDD create(HDD hdd) {
        return hddRepository.save(hdd);
    }

    @Override
    public HDD update(HDD hdd, Integer id) {
        hdd.setId(id);
        return hddRepository.save(hdd);
    }

    @Override
    public List<HDD> getAll() {
        return hddRepository.findAll();
    }

    @Override
    public HDD get(int id) {
        return hddRepository.findById(id).orElseThrow();
    }
}
