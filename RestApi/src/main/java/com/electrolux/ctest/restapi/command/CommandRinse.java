package com.electrolux.ctest.restapi.command;

import com.electrolux.ctest.restapi.ApplianceService;
import com.electrolux.ctest.restapi.persistence.ApplianceState;

/**
 * Command to start rinsing.
 * Created by Admin on 05.05.18.
 */
public class CommandRinse extends Command {

    public CommandRinse() {
        commandId = Commands.RINSE.toString();
    }
    public ApplianceState accept(ApplianceService apService) {
        return apService.executeCommand(this);
    }
}
