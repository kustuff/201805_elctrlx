package com.electrolux.ctest.restapi.persistence;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * The only persistence entity that contains current state of the appliance being controlled.
 * Created by Admin on 04.05.18.
 */
@Entity
@Table(name = "APPLIANCE_STATE")
public class ApplianceState implements Serializable {

    /**
     * Set of available states.
     */
    public static enum States {OFF, ON, WASHING, RINSING, SPINNING, ERROR, NULL};

    @Id
    @Column(name = "state", length = 32)
    @JsonProperty("state")
    String stateId;

    public ApplianceState() {
    }

    public ApplianceState(String stateId) {
        this.stateId = stateId;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
    }

    public static ApplianceState errorState(){
        return new ApplianceState(States.ERROR.toString());
    }

}
