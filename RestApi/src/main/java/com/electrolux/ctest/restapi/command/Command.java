package com.electrolux.ctest.restapi.command;

import com.electrolux.ctest.restapi.ApplianceService;
import com.electrolux.ctest.restapi.persistence.ApplianceState;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Admin on 05.05.18.
 * Abstarct command. Not specified as an abstract class due to auto instatiation fron json.
 */
public class Command {

    /**
     * Set of available commands.
     */
    protected static enum Commands {ON, OFF, WASH, RINSE, SPIN, STOP};

    @JsonProperty("command")
    protected String commandId;

    public Command() {
    }

    /**
     * Stub method for consistencey.
     * @param apService processing service
     * @return null as not used ever.
     */
    public ApplianceState accept(ApplianceService apService) {
        return null;
    }



}
