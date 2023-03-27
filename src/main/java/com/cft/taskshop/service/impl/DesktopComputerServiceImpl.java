package com.cft.taskshop.service.impl;

import com.cft.taskshop.model.DesktopComputer;
import com.cft.taskshop.repository.DesktopComputerRepository;
import com.cft.taskshop.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DesktopComputerServiceImpl implements CommodityService<DesktopComputer> {
    public DesktopComputerRepository desktopComputerRepository;

    @Autowired
    public DesktopComputerServiceImpl(DesktopComputerRepository desktopComputerRepository) {
        this.desktopComputerRepository = desktopComputerRepository;
    }


    @Override
    public DesktopComputer create(DesktopComputer desktopComputer) {
        return desktopComputerRepository.save(desktopComputer);
    }

    @Override
    public DesktopComputer update(DesktopComputer desktopComputer, Integer id) {
        desktopComputer.setId(id);
        return desktopComputerRepository.save(desktopComputer);
    }

    @Override
    public List<DesktopComputer> getAll() {
        return desktopComputerRepository.findAll();
    }

    @Override
    public DesktopComputer get(int id) {
        return desktopComputerRepository.findById(id).orElseThrow();
    }
}
