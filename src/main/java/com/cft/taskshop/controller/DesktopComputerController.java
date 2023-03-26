package com.cft.taskshop.controller;

import com.cft.taskshop.model.DesktopComputer;
import com.cft.taskshop.service.impl.DesktopComputerServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DesktopComputerController {
    private DesktopComputerServiceImpl desktopComputerService;

    public DesktopComputerController(DesktopComputerServiceImpl desktopComputerService) {
        this.desktopComputerService = desktopComputerService;
    }

    @PostMapping("/addDesktop")
    public ResponseEntity<?> create(@RequestBody DesktopComputer desktopComputer) {
        return ResponseEntity.ok(desktopComputerService.create(desktopComputer));
    }

    @PutMapping("/desktop/{desktopId}")
    public ResponseEntity<?> update(@PathVariable(name = "desktopId") int desktopId,
                                    @RequestBody DesktopComputer desktopComputer) {
        ResponseEntity<?> response;
        DesktopComputer returnedComputer;
        returnedComputer = desktopComputerService.update(desktopComputer, desktopId);
        response = ResponseEntity.ok(returnedComputer);
        return response;
    }

    @GetMapping("/desktops")
    public List<DesktopComputer> read() {
        return desktopComputerService.getAll();
    }

    @GetMapping("/desktop/{desktopId}")
    public ResponseEntity<?> get(@PathVariable(name = "desktopId") int desktopId) {
        DesktopComputer returnedComputer = desktopComputerService.get(desktopId);
        return ResponseEntity.ok(returnedComputer);
    }
}
