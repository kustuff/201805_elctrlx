package com.electrolux.ctest.restapi;

import com.electrolux.ctest.restapi.command.*;
import com.electrolux.ctest.restapi.exception.ApplianceException;
import com.electrolux.ctest.restapi.persistence.ApplianceState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Main service performing processing.
 * Created by Admin on 05.05.18.
 */

@Service
public class ApplianceService {

    @Autowired
    private Repository repository;
    @Autowired
    private WashingMachine washingMachine;

    public ApplianceState getState() {
        ApplianceState state = washingMachine.getState();
        if (state == null) {
            state = new ApplianceState(ApplianceState.States.NULL.toString());
        }
        return  state;
    }

    // Execution procedures for different commands. While commands are not parametrized
    // the "Visitor" pattern applied.

    public ApplianceState executeCommand(CommandOn command) {
        ApplianceState state;
        repository.deleteAll();
        try {
            state = washingMachine.on();
        } catch (ApplianceException e) {
            e.printStackTrace();
            // Do smthg...
            state = ApplianceState.errorState();
        }
        repository.save(state);
        return state;
    }

    public ApplianceState executeCommand(CommandOff command) {
        ApplianceState state;
        repository.deleteAll();
        try {
            state = washingMachine.off();
        } catch (ApplianceException e) {
            e.printStackTrace();
            // Do smthg...
            state = ApplianceState.errorState();
        }
        repository.save(state);
        return state;
    }

    public ApplianceState executeCommand(CommandWash command) {
        ApplianceState state;
        repository.deleteAll();
        try {
            state = washingMachine.wash();
        } catch (ApplianceException e) {
            e.printStackTrace();
            // Do smthg...
            state = ApplianceState.errorState();
        }
        repository.save(state);
        return state;
    }

    public ApplianceState executeCommand(CommandRinse command) {
        ApplianceState state;
        repository.deleteAll();
        try {
            state = washingMachine.rinse();
        } catch (ApplianceException e) {
            e.printStackTrace();
            // Do smthg...
            state = ApplianceState.errorState();
        }
        repository.save(state);
        return state;
    }

    public ApplianceState executeCommand(CommandSpin command) {
        ApplianceState state;
        repository.deleteAll();
        try {
            state = washingMachine.spin();
        } catch (ApplianceException e) {
            e.printStackTrace();
            // Do smthg...
            state = ApplianceState.errorState();
        }
        repository.save(state);
        return state;
    }

    public ApplianceState executeCommand(CommandStop command) {
        ApplianceState state;
        repository.deleteAll();
        try {
            state = washingMachine.stop();
        } catch (ApplianceException e) {
            e.printStackTrace();
            // Do smthg...
            state = ApplianceState.errorState();
        }
        repository.save(state);
        return state;
    }

}
