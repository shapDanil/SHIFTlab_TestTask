package com.cft.taskshop.controller;

import com.cft.taskshop.model.DesktopComputer;
import com.cft.taskshop.service.impl.DesktopComputerServiceImpl;
import com.cft.taskshop.validation.EValidationCodeResult;
import com.cft.taskshop.validation.ValidationHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DesktopComputerController {
    private DesktopComputerServiceImpl desktopComputerService;
    @Autowired
    public DesktopComputerController(DesktopComputerServiceImpl desktopComputerService) {
        this.desktopComputerService = desktopComputerService;
    }

    @PostMapping("/addDesktop")
    public ResponseEntity<?> create(@RequestBody DesktopComputer desktopComputer) {
        EValidationCodeResult returnedStatus = ValidationHandler.validateDesktopComputer(desktopComputer);
        if (returnedStatus == EValidationCodeResult.NO_ERROR)
            return ResponseEntity.ok(desktopComputerService.create(desktopComputer));
        return ResponseEntity.internalServerError().body(returnedStatus);
    }

    @PutMapping("/desktop/{desktopId}")
    public ResponseEntity<?> update(@PathVariable(name = "desktopId") int desktopId,
                                    @RequestBody DesktopComputer desktopComputer) {
        DesktopComputer returnedComputer;
        ResponseEntity<?> response;
        EValidationCodeResult returnedStatus = ValidationHandler.validateDesktopComputer(desktopComputer);
        if (returnedStatus == EValidationCodeResult.NO_ERROR) {
            try {
                returnedComputer = desktopComputerService.update(desktopComputer, desktopId);
                response = ResponseEntity.ok(returnedComputer);
            } catch (Exception e) {
                response = ResponseEntity.internalServerError().body(EValidationCodeResult.DESKTOP_COMPUTER_NOT_FOUND);
            }
        } else {
            response = ResponseEntity.internalServerError().body(returnedStatus);
        }
        return response;
    }

    @GetMapping("/desktops")
    public List<DesktopComputer> read() {
        return desktopComputerService.getAll();
    }

    @GetMapping("/desktop/{desktopId}")
    public ResponseEntity<?> get(@PathVariable(name = "desktopId") int desktopId) {
        DesktopComputer returnedComputer;
        try {
            returnedComputer = desktopComputerService.get(desktopId);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(EValidationCodeResult.DESKTOP_COMPUTER_NOT_FOUND);
        }
        return ResponseEntity.ok(returnedComputer);
    }
    @DeleteMapping("/deleteDesktop/{desktopId}")
    public ResponseEntity<?> delete(@PathVariable(name = "desktopId") int desktopId){
        try{
            desktopComputerService.deleteById(desktopId);
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(EValidationCodeResult.DESKTOP_COMPUTER_WAS_NOT_DELETED);
        }
        return ResponseEntity.ok("Entity with id:" + desktopId + " was deleted!");
    }


}
