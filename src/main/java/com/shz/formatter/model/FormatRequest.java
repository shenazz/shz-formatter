package com.shz.formatter.model;

import java.util.Map;

/**
 * @author shenazz
 *
 */
public class FormatRequest {

	public enum Type {
		NUMBER, EMAIL, CURRENCY;
	}

	private Type status;

	private Map<String, Object> details;

	private String version;

}
