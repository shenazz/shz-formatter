/**
 * 
 */
package com.shz.formatter.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author shenazz
 *
 */
public class Currency {

	private String code;

	private double value;

	private Set<Currency> relatedCurrencies;

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

	public Set<Currency> getRelatedCurrencies() {
		if (relatedCurrencies == null) {
			relatedCurrencies = new HashSet<>();
		}
		return relatedCurrencies;
	}

	public void setRelatedCurrencies(Set<Currency> relatedCurrencies) {
		this.relatedCurrencies = relatedCurrencies;
	}

	@Override
	public int hashCode() {
		return Objects.hash(code, relatedCurrencies, value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Currency other = (Currency) obj;
		return Objects.equals(code, other.code) && Objects.equals(relatedCurrencies, other.relatedCurrencies)
				&& Double.doubleToLongBits(value) == Double.doubleToLongBits(other.value);
	}

	@Override
	public String toString() {
		return "Currency [code=" + code + ", value=" + value + ", relatedCurrencies=" + relatedCurrencies + "]";
	}

}
