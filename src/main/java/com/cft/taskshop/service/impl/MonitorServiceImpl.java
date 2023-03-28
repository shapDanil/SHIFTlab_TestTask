package com.cft.taskshop.service.impl;



import com.cft.taskshop.model.Monitor;
import com.cft.taskshop.repository.MonitorRepository;
import com.cft.taskshop.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonitorServiceImpl implements CommodityService<Monitor> {
    public MonitorRepository monitorRepository;

    @Autowired
    public MonitorServiceImpl(MonitorRepository monitorRepository) {
        this.monitorRepository = monitorRepository;
    }

    @Override
    public Monitor create(Monitor laptop) {
        return monitorRepository.save(laptop);
    }

    @Override
    public Monitor update(Monitor monitor, Integer id) {
        monitor.setId(id);
        return monitorRepository.save(monitor);
    }

    @Override
    public List<Monitor> getAll() {
        return monitorRepository.findAll();
    }

    @Override
    public Monitor get(int id) {
        return monitorRepository.findById(id).orElseThrow();
    }

    @Override
    public void deleteById(int id) {
        monitorRepository.deleteById(id);
    }
}
