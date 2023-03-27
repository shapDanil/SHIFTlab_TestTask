package com.cft.taskshop.controller;

import com.cft.taskshop.model.DesktopComputer;
import com.cft.taskshop.model.*;
import com.cft.taskshop.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LaptopController {
    private LaptopServiceImpl laptopService;
    @Autowired
    public LaptopController(LaptopServiceImpl laptopService) {
        this.laptopService = laptopService;
    }

    @PostMapping("/addLaptop")
    public ResponseEntity<?> create(@RequestBody Laptop laptop) {
        System.out.println("sdasd");
        return ResponseEntity.ok(laptopService.create(laptop));
    }

    @PutMapping("/laptop/{laptopId}")
    public ResponseEntity<?> update(@PathVariable(name = "laptopId") int desktopId,
                                    @RequestBody Laptop laptop) {
        ResponseEntity<?> response;
        Laptop returnedComputer = laptopService.update(laptop, desktopId);
        response = ResponseEntity.ok(returnedComputer);
        return response;
    }

    @GetMapping("/laptops")
    public List<Laptop> read() {
        return laptopService.getAll();
    }

    @GetMapping("/laptop/{laptopId}")
    public ResponseEntity<?> get(@PathVariable(name = "laptopId") int desktopId) {
        Laptop returnedLaptop = laptopService.get(desktopId);
        ResponseEntity<?> response = ResponseEntity.ok(returnedLaptop);
        return response;
    }
}
