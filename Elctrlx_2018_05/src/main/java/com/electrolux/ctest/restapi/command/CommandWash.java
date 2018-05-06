package com.electrolux.ctest.restapi.command;

import com.electrolux.ctest.restapi.ApplianceService;
import com.electrolux.ctest.restapi.persistence.ApplianceState;

/**
 * Command to start washing.
 * Created by Admin on 05.05.18.
 */
public class CommandWash extends Command {

    public CommandWash() {
        commandId = Commands.WASH.toString();
    }
    public ApplianceState accept(ApplianceService apService) {
        return apService.executeCommand(this);
    }
}
