package com.electrolux.ctest.restapi;

import com.electrolux.ctest.restapi.command.Command;
import com.electrolux.ctest.restapi.command.CommandFactory;
import com.electrolux.ctest.restapi.persistence.ApplianceState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Main REST controller.
 * Created by Admin on 04.05.18.
 */

@RestController
@RequestMapping(path = "/RestApiApplianceApp")
public class ApplianceController {

    @Autowired
    private ApplianceService service;

    @GetMapping("/state")
    @ResponseStatus(HttpStatus.OK)
    public ApplianceState getApplianceState() {
        return service.getState();
    }

    @PostMapping("/execute")
    @ResponseStatus(HttpStatus.OK)
    public ApplianceState executeCommand(@RequestBody Command command) {
        Command commandImpl = CommandFactory.createCommand(command);
        return commandImpl.accept(service);
    }

}
