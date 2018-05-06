package com.electrolux.ctest.restapi.command;

import com.electrolux.ctest.restapi.ApplianceService;
import com.electrolux.ctest.restapi.persistence.ApplianceState;

/**
 * Command to switch appliance on
 * Created by Admin on 05.05.18.
 */
public class CommandOn extends Command {

    public CommandOn() {
        commandId = Commands.ON.toString();
    }
    public ApplianceState accept(ApplianceService apService) {
        return apService.executeCommand(this);
    }
}
