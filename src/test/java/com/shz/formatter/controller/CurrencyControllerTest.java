/**
 * 
 */
package com.shz.formatter.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.shz.formatter.model.Currency;
import com.shz.formatter.service.CurrencyService;

/**
 * @author shenazz
 *
 */
@WebMvcTest(CurrencyController.class)
public class CurrencyControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CurrencyService currencyService;

	@Test
	void give_serviceReturnsValidResponse_when_getLatestRates_then_okWithValidResponse() throws Exception {
		// given
		String input = "10 JPY";

		Currency currency = new Currency();
		currency.setCode("JPY");
		currency.setValue(10.0);

		given(currencyService.convert(input)).willReturn(currency);

		// when and then
		mockMvc.perform(MockMvcRequestBuilders.get("/currency/latest-rates").param("input", input).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.code").value(currency.getCode()))
				.andExpect(MockMvcResultMatchers.jsonPath("$.value").value(currency.getValue()));
	}

}
