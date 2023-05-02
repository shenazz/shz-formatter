/**
 * 
 */
package com.shz.formatter.client;

import java.util.Map;

import com.shz.formatter.model.Currency;

/**
 * @author shenazz
 *
 */
public interface ExchangeRateClient {

	public Map<String, Double> getLatestRates(Currency currency);

}
