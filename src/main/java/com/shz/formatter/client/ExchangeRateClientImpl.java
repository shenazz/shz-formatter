package com.shz.formatter.client;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.shz.formatter.model.ExchangeRatesResponse;
import com.shz.formatter.model.Currency;

/**
 * @author shenazz
 *
 */
@Service
public class ExchangeRateClientImpl implements ExchangeRateClient {

	@Value("${app.currency.exchange-rate-client.url}")
	private String url;

	@Value("${app.currency.exchange-rate-client.apikey}")
	private String apikey;

	@Value("${app.currency.exchange-rate-client.supported-symbols}")
	private String[] supportedSymbols;

	@Value("${app.currency.exchange-rate-client.default-base-symbol}")
	private String defaultBaseSymbol;

	private RestTemplate restTemplate;

	public ExchangeRateClientImpl() {
		restTemplate = new RestTemplate();
	}

	@Override
	public Map<String, Double> getLatestRates(Currency currency) {

		if (!StringUtils.hasText(currency.getCode())) {
			currency.setCode(defaultBaseSymbol);
		}

		HttpHeaders headers = new HttpHeaders();
		headers.set("apikey", apikey);
		HttpEntity<String> entity = new HttpEntity<>(headers);

		ResponseEntity<ExchangeRatesResponse> response = restTemplate.exchange(url, HttpMethod.GET, entity, ExchangeRatesResponse.class,
				currency.getCode(), String.join(",", supportedSymbols));

		if (!response.getBody().isSuccess()) {
			throw new RuntimeException("Unexpected exception while invoking exchange rate API");
		}

		return response.getBody().getRates();
	}

}
