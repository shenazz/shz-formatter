/**
 * 
 */
package com.shz.formatter.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import static org.mockito.BDDMockito.given;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.shz.formatter.client.ExchangeRateClient;
import com.shz.formatter.exception.InvalidValueException;
import com.shz.formatter.model.Currency;

/**
 * @author Shenaz Assu
 *
 */
@SpringBootTest
public class CurrencyServiceTest {

	@Autowired
	private CurrencyService currencyService;

	@MockBean
	private ExchangeRateClient exchangeRateClient;

	@Test
	void given_validInput_when_convert_then_currenciesReturned() throws InvalidValueException {

		//given
		String input = "100 USD";
		Currency currency = new Currency();
		currency.setCode("USD");
		currency.setValue(100.0);

		Map<String, Double> latestRates = new HashMap<>();
		latestRates.put("EUR", 0.9);
		latestRates.put("GBP", 0.8);

		given(exchangeRateClient.getLatestRates(currency)).willReturn(latestRates);

		//when
		Currency result = currencyService.convert(input);

		//then
		assertThat(result).isNotNull();
		assertThat(result.getCode()).isEqualTo("USD");
		assertThat(result.getValue()).isEqualTo(100.0);

		assertThat(result.getRelatedCurrencies().size()).isEqualTo(2);

		Currency eurResult = result.getRelatedCurrencies().stream().filter(related -> related.getCode().equals("EUR")).findAny()
				.orElse(null);
		assertThat(eurResult).isNotNull();
		assertThat(eurResult.getCode()).isEqualTo("EUR");
		assertThat(eurResult.getValue()).isEqualTo(90.0);

		Currency gbpResult = result.getRelatedCurrencies().stream().filter(related -> related.getCode().equals("GBP")).findAny()
				.orElse(null);
		assertThat(gbpResult).isNotNull();
		assertThat(gbpResult.getCode()).isEqualTo("GBP");
		assertThat(gbpResult.getValue()).isEqualTo(80.0);

	}

	@Test
	void given_invalidInput_when_convert_the_exception() {
		//given
		String input = "EUR";

		try {

			//when
			currencyService.convert(input);

			fail("Expected InvalidValueException to be thrown");
		} catch (InvalidValueException e) {

			//then
			//expected
		}

	}

}
