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
public class MonitorController {
    private MonitorServiceImpl monitorService;
    @Autowired
    public MonitorController(MonitorServiceImpl laptopService) {
        this.monitorService = laptopService;
    }

    @PostMapping("/addMonitor")
    public ResponseEntity<?> create(@RequestBody Monitor monitor) {
        EValidationCodeResult returnedStatus = ValidationHandler.validateMonitor(monitor);
        if (returnedStatus == EValidationCodeResult.NO_ERROR)
            return ResponseEntity.ok(monitorService.create(monitor));
        return ResponseEntity.internalServerError().body(returnedStatus);
    }

    @PutMapping("/monitor/{monitorId}")
    public ResponseEntity<?> update(@PathVariable(name = "monitorId") int monitorId,
                                    @RequestBody Monitor monitor) {
        Monitor returnedMonitor;
        ResponseEntity<?> response;
        EValidationCodeResult returnedStatus = ValidationHandler.validateMonitor(monitor);
        if (returnedStatus == EValidationCodeResult.NO_ERROR) {
            try {
                returnedMonitor = monitorService.update(monitor, monitorId);
                response = ResponseEntity.ok(returnedMonitor);
            } catch (Exception e) {
                response = ResponseEntity.internalServerError().body(EValidationCodeResult.MONITOR_NOT_FOUND);
            }
        } else {
            response = ResponseEntity.internalServerError().body(returnedStatus);
        }
        return response;
    }

    @GetMapping("/monitors")
    public List<Monitor> read() {
        return monitorService.getAll();
    }

    @GetMapping("/monitor/{monitorId}")
    public ResponseEntity<?> get(@PathVariable(name = "monitorId") int monitorId) {
        Monitor returnedMonitor;
        try {
            returnedMonitor = monitorService.get(monitorId);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(EValidationCodeResult.MONITOR_NOT_FOUND);
        }
        return ResponseEntity.ok(returnedMonitor);
    }
    @DeleteMapping("/deleteMonitor/{monitorId}")
    public ResponseEntity<?> delete(@PathVariable(name = "monitorId") int monitorId){
        try{
            monitorService.deleteById(monitorId);
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(EValidationCodeResult.MONITOR_WAS_NOT_DELETED);
        }
        return ResponseEntity.ok("Entity with id:" + monitorId + " was deleted!");
    }
}
