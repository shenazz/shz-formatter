/**
 * 
 */
package com.shz.formatter.model;

import java.util.Objects;

/**
 * @author shenazz
 *
 */
public class Email {

	private String value;

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Email other = (Email) obj;
		return Objects.equals(value, other.value);
	}

	@Override
	public String toString() {
		return "Email [value=" + value + "]";
	}

}
