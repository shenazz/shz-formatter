package com.shz.formatter.model;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shenazz
 *
 */
public class ServiceHealth {

	private ServiceHealthStatus status;

	private Map<String, Object> details;

	private String version;

	/**
	 * 
	 */
	public ServiceHealth() {
		status = ServiceHealthStatus.PASS;
		details = new HashMap<>();
	}

	/**
	 * @param status
	 */
	public ServiceHealth(ServiceHealthStatus status) {
		super();
		this.status = status;
	}

	/**
	 * @return the status
	 */
	public ServiceHealthStatus getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(ServiceHealthStatus status) {
		this.status = status;
	}

	/**
	 * @return the components
	 */
	public Map<String, Object> getDetails() {
		return details;
	}

	/**
	 * @param components
	 *            the components to set
	 */
	public void setDetails(Map<String, Object> details) {
		this.details = details;
	}

	/**
	 * Add details about a sub component.
	 * 
	 * @param component
	 * @param information
	 */
	public void addDetails(String component, Object information) {
		this.details.put(component, information);
	}

	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @param version
	 *            the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}

}
