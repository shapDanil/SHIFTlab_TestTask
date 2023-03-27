package com.cft.taskshop.controller;


import com.cft.taskshop.model.*;
import com.cft.taskshop.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HDDController {
    private HDDServiceImpl hddService;
    @Autowired
    public HDDController(HDDServiceImpl hddService) {
        this.hddService = hddService;
    }

    @PostMapping("/addHDD")
    public ResponseEntity<?> create(@RequestBody HDD hdd) {
        return ResponseEntity.ok(hddService.create(hdd));
    }

    @PutMapping("/HDD/{IdHDD}")
    public ResponseEntity<?> update(@PathVariable(name = "IdHDD") int desktopId,
                                    @RequestBody HDD hdd) {
        ResponseEntity<?> response;
        HDD returnedComputer = hddService.update(hdd, desktopId);
        response = ResponseEntity.ok(returnedComputer);
        return response;
    }

    @GetMapping("/allHDD")
    public List<HDD> read() {
        return hddService.getAll();
    }

    @GetMapping("/HDD/{IdHDD}")
    public ResponseEntity<?> get(@PathVariable(name = "IdHDD") int desktopId) {
        HDD returnedLaptop = hddService.get(desktopId);
        ResponseEntity<?> response = ResponseEntity.ok(returnedLaptop);
        return response;
    }
}
