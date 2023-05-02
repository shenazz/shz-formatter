package com.shz.formatter.model;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shenazz
 *
 */
public class ServiceStatus {

	public enum Status {
		/** API is up and running with all functions */
		pass,
		/** API is running but the status needs attention */
		warn,
		/** API is experiencing severe problems, services are not working */
		fail;
	}

	private Status status;

	private Map<String, Object> details;

	private String version;

	/**
	 * 
	 */
	public ServiceStatus() {
		status = Status.pass;
		details = new HashMap<>();
	}

	/**
	 * @param status
	 */
	public ServiceStatus(Status status) {
		super();
		this.status = status;
	}

	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(Status status) {
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
