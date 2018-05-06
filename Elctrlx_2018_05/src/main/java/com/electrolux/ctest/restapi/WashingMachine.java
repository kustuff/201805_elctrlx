package com.electrolux.ctest.restapi;

import com.electrolux.ctest.restapi.exception.ApplianceException;
import com.electrolux.ctest.restapi.persistence.ApplianceState;
import org.springframework.stereotype.Component;

/**
 * Concrete implementation of appliance - washing machine.
 * Created by Admin on 05.05.18.
 */
@Component
public class WashingMachine extends Appliance {

    @Override
    public ApplianceState on() throws ApplianceException {
        // Do smthg...
        setState(new ApplianceState(ApplianceState.States.ON.toString()));
        return state;
    }

    @Override
    public ApplianceState off() throws ApplianceException {
        // Do smthg...
        setState(new ApplianceState(ApplianceState.States.OFF.toString()));
        return state;
    }

    public ApplianceState wash() throws ApplianceException {
        // Start washing asynchronously...
        setState(new ApplianceState(ApplianceState.States.WASHING.toString()));
        return state;
    }

    public ApplianceState rinse() throws ApplianceException {
        // Start rinsing asynchronously...
        setState(new ApplianceState(ApplianceState.States.RINSING.toString()));
        return state;
    }

    public ApplianceState spin() throws ApplianceException {
        // Start spinning asynchronously...
        setState(new ApplianceState(ApplianceState.States.SPINNING.toString()));
        return state;
    }

    public ApplianceState stop() throws ApplianceException {
        // Do smthg...
        setState(new ApplianceState(ApplianceState.States.ON.toString()));
        return state;
    }

}
