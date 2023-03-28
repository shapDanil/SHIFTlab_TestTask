package com.cft.taskshop.controller;

import com.cft.taskshop.model.DesktopComputer;
import com.cft.taskshop.model.*;
import com.cft.taskshop.service.impl.*;
import com.cft.taskshop.validation.EValidationCodeResult;
import com.cft.taskshop.validation.ValidationHandler;
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
        EValidationCodeResult returnedStatus = ValidationHandler.validateLaptop(laptop);
        if (returnedStatus == EValidationCodeResult.NO_ERROR)
            return ResponseEntity.ok(laptopService.create(laptop));
        return ResponseEntity.internalServerError().body(returnedStatus);
    }

    @PutMapping("/laptop/{laptopId}")
    public ResponseEntity<?> update(@PathVariable(name = "laptopId") int laptopId,
                                    @RequestBody Laptop laptop) {
        Laptop returnedLaptop;
        ResponseEntity<?> response;
        EValidationCodeResult returnedStatus = ValidationHandler.validateLaptop(laptop);
        if (returnedStatus == EValidationCodeResult.NO_ERROR) {
            try {
                returnedLaptop = laptopService.update(laptop, laptopId);
                response = ResponseEntity.ok(returnedLaptop);
            } catch (Exception e) {
                response = ResponseEntity.internalServerError().body(EValidationCodeResult.LAPTOP_NOT_FOUND);
            }
        } else {
            response = ResponseEntity.internalServerError().body(returnedStatus);
        }
        return response;
    }

    @GetMapping("/laptops")
    public List<Laptop> read() {
        return laptopService.getAll();
    }

    @GetMapping("/laptop/{laptopId}")
    public ResponseEntity<?> get(@PathVariable(name = "laptopId") int laptopId) {
        Laptop returnedLaptop;
        try {
            returnedLaptop = laptopService.get(laptopId);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(EValidationCodeResult.LAPTOP_NOT_FOUND);
        }
        return ResponseEntity.ok(returnedLaptop);
    }
}
