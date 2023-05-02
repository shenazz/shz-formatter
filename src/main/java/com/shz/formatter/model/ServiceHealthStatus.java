/**
 * 
 */
package com.shz.formatter.model;

/**
 * @author shenazz
 *
 */
public enum ServiceHealthStatus {
	/** API is up and running with all functions */
	PASS,
	/** API is running but the status needs attention */
	WARN,
	/** API is experiencing severe problems, services are not working */
	FAIL;
}
