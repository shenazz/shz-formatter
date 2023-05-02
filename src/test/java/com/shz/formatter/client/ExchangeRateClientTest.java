package com.shz.formatter.client;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import com.shz.formatter.model.Currency;
import com.shz.formatter.model.ExchangeRatesResponse;

/**
 * @author shenazz
 *
 */
@SpringBootTest
public class ExchangeRateClientTest {

	@Autowired
	private ExchangeRateClient exchangeRateClient;

	@MockBean
	private RestTemplate restTemplate;

	private String url = "http://example.com";

	private String apikey = "test-api-key";

	private String[] supportedSymbols = new String[] { "USD", "EUR", "GBP" };

	private String defaultBaseSymbol = "USD";

	@BeforeEach
	void setUp() {
		ReflectionTestUtils.setField(exchangeRateClient, "url", url);
		ReflectionTestUtils.setField(exchangeRateClient, "apikey", apikey);
		ReflectionTestUtils.setField(exchangeRateClient, "supportedSymbols", supportedSymbols);
		ReflectionTestUtils.setField(exchangeRateClient, "defaultBaseSymbol", defaultBaseSymbol);
		ReflectionTestUtils.setField(exchangeRateClient, "restTemplate", restTemplate);
	}

	@Test
	void given_currencyWithCode_when_getRates_then_ratesReturned() {
		//given
		HttpHeaders headers = new HttpHeaders();
		headers.set("apikey", apikey);
		HttpEntity<String> entity = new HttpEntity<>(headers);

		Map<String, Double> rates = new HashMap<>();
		rates.put("EUR", 0.8);
		rates.put("GBP", 0.7);
		rates.put("USD", 0.6);

		ExchangeRatesResponse exchangeRatesResponse = new ExchangeRatesResponse();
		exchangeRatesResponse.setSuccess(true);
		exchangeRatesResponse.setRates(rates);

		ResponseEntity<ExchangeRatesResponse> responseEntity = new ResponseEntity<>(exchangeRatesResponse, HttpStatus.OK);

		String baseSymbol = "INR";
		given(restTemplate.exchange(eq(url), eq(HttpMethod.GET), eq(entity), eq(ExchangeRatesResponse.class), eq(baseSymbol),
				eq(String.join(",", supportedSymbols)))).willReturn(responseEntity);

		Currency currency = new Currency();
		currency.setCode(baseSymbol);

		//when
		Map<String, Double> result = exchangeRateClient.getLatestRates(currency);

		// then
		assertThat(result.size()).isEqualTo(3);
		assertThat(result.get("EUR")).isEqualTo(0.8);
		assertThat(result.get("GBP")).isEqualTo(0.7);
		assertThat(result.get("USD")).isEqualTo(0.6);
	}

	@Test
	void given_currencyWithNoCode_when_getRates_then_ratesReturned() {
		// given
		HttpHeaders headers = new HttpHeaders();
		headers.set("apikey", apikey);
		HttpEntity<String> entity = new HttpEntity<>(headers);

		Map<String, Double> rates = new HashMap<>();
		rates.put("EUR", 0.8);
		rates.put("GBP", 0.7);
		rates.put("USD", 1.0);

		ExchangeRatesResponse exchangeRatesResponse = new ExchangeRatesResponse();
		exchangeRatesResponse.setSuccess(true);
		exchangeRatesResponse.setRates(rates);

		ResponseEntity<ExchangeRatesResponse> responseEntity = new ResponseEntity<>(exchangeRatesResponse, HttpStatus.OK);

		String baseSymbol = null;
		given(restTemplate.exchange(eq(url), eq(HttpMethod.GET), eq(entity), eq(ExchangeRatesResponse.class), eq(defaultBaseSymbol),
				eq(String.join(",", supportedSymbols)))).willReturn(responseEntity);

		Currency currency = new Currency();
		currency.setCode(baseSymbol);

		// when
		Map<String, Double> result = exchangeRateClient.getLatestRates(currency);

		// then
		assertThat(result.size()).isEqualTo(3);
		assertThat(result.get("EUR")).isEqualTo(0.8);
		assertThat(result.get("GBP")).isEqualTo(0.7);
		assertThat(result.get("USD")).isEqualTo(1.0);
	}

	@Test
	void given_apiError_when_getRates_then_exception() {
		// given
		HttpHeaders headers = new HttpHeaders();
		headers.set("apikey", apikey);
		HttpEntity<String> entity = new HttpEntity<>(headers);

		ExchangeRatesResponse exchangeRatesResponse = new ExchangeRatesResponse();
		exchangeRatesResponse.setSuccess(false);

		ResponseEntity<ExchangeRatesResponse> responseEntity = new ResponseEntity<>(exchangeRatesResponse, HttpStatus.OK);

		String baseSymbol = null;
		given(restTemplate.exchange(eq(url), eq(HttpMethod.GET), eq(entity), eq(ExchangeRatesResponse.class), eq(defaultBaseSymbol),
				eq(String.join(",", supportedSymbols)))).willReturn(responseEntity);

		Currency currency = new Currency();
		currency.setCode(baseSymbol);

		try {
			// when
			Map<String, Double> result = exchangeRateClient.getLatestRates(currency);
			fail("RuntimeException expected");
		} catch (RuntimeException e) {
			// then
			// exception expected
		}

	}

}
