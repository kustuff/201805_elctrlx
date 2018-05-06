package com.electrolux.ctest.restapi;

import com.electrolux.ctest.restapi.exception.ApplianceException;
import com.electrolux.ctest.restapi.persistence.ApplianceState;

/**
 * Interface for any appliance.
 * Created by Admin on 05.05.18.
 */
public abstract class Appliance {

    protected ApplianceState state;

    public ApplianceState getState(){
        return state;
    }

    public void setState(ApplianceState state) {
        this.state = state;
    }

    public void setState(String state) {
        if (this.state == null) {
            this.state = new ApplianceState();
        }
        this.state.setStateId(state);
    }

    /** Common command for any appliance - switch on*/
    public abstract ApplianceState on() throws ApplianceException;
    /** Common command for any appliance  - switch off */
    public abstract ApplianceState off() throws ApplianceException;
}
