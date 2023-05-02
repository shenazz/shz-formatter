/**
 * 
 */
package com.shz.formatter.model;

import java.util.Objects;

/**
 * @author shenazz
 *
 */
public class Currency {

	private String code;

	private double value;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(code, value);
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
		Currency other = (Currency) obj;
		return Objects.equals(code, other.code) && Double.doubleToLongBits(value) == Double.doubleToLongBits(other.value);
	}

	@Override
	public String toString() {
		return "Currency [code=" + code + ", value=" + value + "]";
	}

}
