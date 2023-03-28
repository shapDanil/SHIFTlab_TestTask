package com.cft.taskshop.controller;


import com.cft.taskshop.model.*;
import com.cft.taskshop.service.impl.*;
import com.cft.taskshop.validation.EValidationCodeResult;
import com.cft.taskshop.validation.ValidationHandler;
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
        EValidationCodeResult returnedStatus = ValidationHandler.validateHDD(hdd);
        if (returnedStatus == EValidationCodeResult.NO_ERROR)
            return ResponseEntity.ok(hddService.create(hdd));
        return ResponseEntity.internalServerError().body(returnedStatus);
    }

    @PutMapping("/HDD/{hddID}")
    public ResponseEntity<?> update(@PathVariable(name = "hddID") int hddID,
                                    @RequestBody HDD hdd) {
        HDD returnedHDD;
        ResponseEntity<?> response;
        EValidationCodeResult returnedStatus = ValidationHandler.validateHDD(hdd);
        if (returnedStatus == EValidationCodeResult.NO_ERROR) {
            try {
                returnedHDD = hddService.update(hdd, hddID);
                response = ResponseEntity.ok(returnedHDD);
            } catch (Exception e) {
                response = ResponseEntity.internalServerError().body(EValidationCodeResult.HDD_NOT_FOUND);
            }
        } else {
            response = ResponseEntity.internalServerError().body(returnedStatus);
        }
        return response;
    }

    @GetMapping("/allHDD")
    public List<HDD> read() {
        return hddService.getAll();
    }

    @GetMapping("/HDD/{hddId}")
    public ResponseEntity<?> get(@PathVariable(name = "hddId") int hddId) {
        HDD returnedHDD;
        try {
            returnedHDD = hddService.get(hddId);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(EValidationCodeResult.HDD_NOT_FOUND);
        }
        return ResponseEntity.ok(returnedHDD);
    }
    @DeleteMapping("/deleteHDD/{hddID}")
    public ResponseEntity<?> delete(@PathVariable(name = "hddID") int hddID){
        try{
            hddService.deleteById(hddID);
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(EValidationCodeResult.HDD_WAS_NOT_DELETED);
        }
        return ResponseEntity.ok("Entity with id:" + hddID + " was deleted!");
    }
}
