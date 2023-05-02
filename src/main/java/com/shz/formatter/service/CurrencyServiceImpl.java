/**
 * 
 */
package com.shz.formatter.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.shz.formatter.client.ExchangeRateClient;
import com.shz.formatter.core.CurrencyFormatter;
import com.shz.formatter.exception.InvalidValueException;
import com.shz.formatter.model.Currency;
import com.shz.formatter.model.FormatResultStatus;
import com.shz.formatter.model.FormatterResult;

/**
 * @author Shenaz Assu
 *
 */
@Service
public class CurrencyServiceImpl implements CurrencyService {

	@Autowired
	private ExchangeRateClient apiLayerClient;

	@Override
	public Currency convert(String input) throws InvalidValueException {
		FormatterResult<Currency> parseResult = new CurrencyFormatter().parse(input);
		if (parseResult.getStatus() != FormatResultStatus.OK) {
			throw new InvalidValueException(parseResult.getMsg());
		}

		Currency currency = parseResult.getResult();

		Map<String, Double> latestRates = apiLayerClient.getLatestRates(currency);
		for (Map.Entry<String, Double> entry : latestRates.entrySet()) {
			Currency relatedCurrency = new Currency();
			relatedCurrency.setCode(entry.getKey());
			relatedCurrency.setValue(currency.getValue() * entry.getValue());

			currency.getRelatedCurrencies().add(relatedCurrency);
		}

		return currency;
	}

}
