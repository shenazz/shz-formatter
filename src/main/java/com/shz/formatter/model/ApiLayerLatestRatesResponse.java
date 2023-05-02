/**
 * 
 */
package com.shz.formatter.model;

import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Shenaz Assu
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiLayerLatestRatesResponse {

	private boolean success;

	private String base;

	private Map<String, Double> rates;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public Map<String, Double> getRates() {
		return rates;
	}

	public void setRates(Map<String, Double> rates) {
		this.rates = rates;
	}

	@Override
	public int hashCode() {
		return Objects.hash(base, rates, success);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ApiLayerLatestRatesResponse other = (ApiLayerLatestRatesResponse) obj;
		return Objects.equals(base, other.base) && Objects.equals(rates, other.rates) && success == other.success;
	}

	@Override
	public String toString() {
		return "ApiLayerLatestRatesResponse [success=" + success + ", base=" + base + ", rates=" + rates + "]";
	}

}
