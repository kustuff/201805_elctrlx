package com.electrolux.ctest.restapi.command;

import com.electrolux.ctest.restapi.ApplianceService;
import com.electrolux.ctest.restapi.persistence.ApplianceState;

/**
 * Command to stop any procedure.
 * Created by Admin on 05.05.18.
 */
public class CommandStop extends Command {

    public CommandStop() {
        commandId = Commands.STOP.toString();
    }
    public ApplianceState accept(ApplianceService apService) {
        return apService.executeCommand(this);
    }
}
