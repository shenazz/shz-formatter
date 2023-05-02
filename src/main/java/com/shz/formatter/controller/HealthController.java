package com.shz.formatter.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shz.formatter.model.ServiceHealth;
import com.shz.formatter.model.ServiceHealthStatus;

import io.swagger.annotations.ApiOperation;

/**
 * @author shenazz
 *
 */
@RestController
public class HealthController {

	/**
	 * Returns a status message based on the internal state of the API.
	 * 
	 * @return
	 */
	@GetMapping(path = "/health", produces = "application/health+json")
	@ApiOperation(value = "Verify that the API is available", notes = "Used by monitoring tools to check the health status of this API.")
	public ResponseEntity<Object> healthCheck() {
		ServiceHealth status = getStatus();
		if (status.getStatus() == ServiceHealthStatus.FAIL) {
			return new ResponseEntity<>(getStatus(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(getStatus(), HttpStatus.OK);
	}

	/**
	 * Builds the status object which is used in the response. Implementations can override this method to add additional details.
	 * 
	 * @return
	 */
	public ServiceHealth getStatus() {
		ServiceHealth status = new ServiceHealth();
		return status;
	}
}
