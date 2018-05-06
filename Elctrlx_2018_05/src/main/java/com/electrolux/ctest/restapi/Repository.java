package com.electrolux.ctest.restapi;

import com.electrolux.ctest.restapi.persistence.ApplianceState;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository for persistence control by Spring.
 * Created by Admin on 05.05.18.
 */
public interface Repository extends CrudRepository<ApplianceState, String> {
}
