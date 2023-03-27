package com.cft.taskshop.controller;

import com.cft.taskshop.model.*;
import com.cft.taskshop.service.impl.*;
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
        return ResponseEntity.ok(monitorService.create(monitor));
    }

    @PutMapping("/monitor/{monitorId}")
    public ResponseEntity<?> update(@PathVariable(name = "monitorId") int desktopId,
                                    @RequestBody Monitor monitor) {
        ResponseEntity<?> response;
        Monitor returnedComputer = monitorService.update(monitor, desktopId);
        response = ResponseEntity.ok(returnedComputer);
        return response;
    }

    @GetMapping("/monitors")
    public List<Monitor> read() {
        return monitorService.getAll();
    }

    @GetMapping("/monitor/{monitorId}")
    public ResponseEntity<?> get(@PathVariable(name = "monitorId") int desktopId) {
        Monitor returnedLaptop = monitorService.get(desktopId);
        ResponseEntity<?> response = ResponseEntity.ok(returnedLaptop);
        return response;
    }
}
