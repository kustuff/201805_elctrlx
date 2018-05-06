package com.electrolux.ctest.restapi.command;

import com.electrolux.ctest.restapi.exception.UnknownCommandException;

/**
 * Created by Admin on 05.05.18.
 */
public class CommandFactory {

    /**
     *
     * @param command abstract command from json.
     * @return concrete command.
     */
    public static Command createCommand(Command command) {
        if (Command.Commands.ON.toString().equalsIgnoreCase(command.commandId)) {
            return new CommandOn();
        } else if (Command.Commands.OFF.toString().equalsIgnoreCase(command.commandId)) {
            return new CommandOff();
        } else if (Command.Commands.WASH.toString().equalsIgnoreCase(command.commandId)) {
            return new CommandWash();
        } else if (Command.Commands.RINSE.toString().equalsIgnoreCase(command.commandId)) {
            return new CommandRinse();
        } else if (Command.Commands.SPIN.toString().equalsIgnoreCase(command.commandId)) {
            return new CommandSpin();
        } else if (Command.Commands.STOP.toString().equalsIgnoreCase(command.commandId)) {
            return new CommandStop();
        }

        throw new UnknownCommandException();
    }
}
