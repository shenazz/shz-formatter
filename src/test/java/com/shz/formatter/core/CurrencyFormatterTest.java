/**
 * 
 */
package com.shz.formatter.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.shz.formatter.model.Currency;
import com.shz.formatter.model.FormatterResult;
import com.shz.formatter.model.FormatResultStatus;
import com.shz.formatter.service.CurrencyFormatterService;

/**
 * @author shenazz
 *
 */
public class CurrencyFormatterTest {

	@Test
	public void given_inputIsValid_when_parse_then_success() {

		//given
		String input = "10.5 EUR";

		//when
		CurrencyFormatterService formatter = new CurrencyFormatterService();
		FormatterResult<Currency> result = formatter.parse(input);

		//then
		assertEquals(FormatResultStatus.OK, result.getStatus());
		assertNotNull(result.getResult());
		assertEquals("EUR", result.getResult().getCode());
		assertEquals(10.5, result.getResult().getValue());

	}

	@Test
	public void given_inputWithLowerCaseCode_when_parse_then_success() {

		//given
		String input = "10.5 eur";

		//when
		CurrencyFormatterService formatter = new CurrencyFormatterService();
		FormatterResult<Currency> result = formatter.parse(input);

		//then
		assertEquals(FormatResultStatus.OK, result.getStatus());
		assertNotNull(result.getResult());
		assertEquals("EUR", result.getResult().getCode());
		assertEquals(10.5, result.getResult().getValue());
	}

	@Test
	public void given_inputWithSpaces_when_parse_then_success() {

		//given
		String input = "  10.5 EUR  ";

		//when
		CurrencyFormatterService formatter = new CurrencyFormatterService();
		FormatterResult<Currency> result = formatter.parse(input);

		//then
		assertEquals(FormatResultStatus.OK, result.getStatus());
		assertNotNull(result.getResult());
		assertEquals("EUR", result.getResult().getCode());
		assertEquals(10.5, result.getResult().getValue());
	}

	@Test
	public void given_inputWithSpacesInBetween_when_parse_then_success() {

		//given
		String input = "  10.5      EUR  ";

		//when
		CurrencyFormatterService formatter = new CurrencyFormatterService();
		FormatterResult<Currency> result = formatter.parse(input);

		//then
		assertEquals(FormatResultStatus.OK, result.getStatus());
		assertNotNull(result.getResult());
		assertEquals("EUR", result.getResult().getCode());
		assertEquals(10.5, result.getResult().getValue());
	}

	@Test
	public void given_inputIsInvalid_when_parse_then_error() {

		//given
		String input = "10.5 ";

		//when
		CurrencyFormatterService formatter = new CurrencyFormatterService();
		FormatterResult<Currency> result = formatter.parse(input);

		//then
		assertEquals(FormatResultStatus.ERROR, result.getStatus());
		assertTrue(!result.getMsg().isBlank());
	}

	@Test
	public void given_inputIsNotDigit_when_parse_then_error() {

		//given
		String input = "AAA EUR";

		//when
		CurrencyFormatterService formatter = new CurrencyFormatterService();
		FormatterResult<Currency> result = formatter.parse(input);

		//then
		assertEquals(FormatResultStatus.ERROR, result.getStatus());
		assertTrue(!result.getMsg().isBlank());
	}

	@Test
	public void given_inputIsEmpty_when_parse_then_error() {

		//given
		String input = "";

		//when
		CurrencyFormatterService formatter = new CurrencyFormatterService();
		FormatterResult<Currency> result = formatter.parse(input);

		//then
		assertEquals(FormatResultStatus.ERROR, result.getStatus());
		assertTrue(!result.getMsg().isBlank());
	}

	@Test
	public void given_inputIsNull_when_parse_then_error() {

		//given
		String input = null;

		//when
		CurrencyFormatterService formatter = new CurrencyFormatterService();
		FormatterResult<Currency> result = formatter.parse(input);

		//then
		assertEquals(FormatResultStatus.ERROR, result.getStatus());
		assertTrue(!result.getMsg().isBlank());
	}

	@Test
	public void given_inputIsValid_when_isValid_then_success() {

		//given
		String input = "10.5 EUR";

		//when
		CurrencyFormatterService formatter = new CurrencyFormatterService();
		boolean result = formatter.isValidValue(input);

		//then
		assertTrue(result);

	}

	@Test
	public void given_inputWithLowerCaseCode_when_isValid_then_success() {

		//given
		String input = "10.5 eur";

		//when
		CurrencyFormatterService formatter = new CurrencyFormatterService();
		boolean result = formatter.isValidValue(input);

		//then
		assertTrue(result);
	}

	@Test
	public void given_inputWithSpaces_when_isValid_then_success() {

		//given
		String input = "  10.5 EUR  ";

		//when
		CurrencyFormatterService formatter = new CurrencyFormatterService();
		boolean result = formatter.isValidValue(input);

		//then
		assertTrue(result);
	}

	@Test
	public void given_inputWithSpacesInBetween_when_isValid_then_success() {

		//given
		String input = "  10.5      EUR  ";

		//when
		CurrencyFormatterService formatter = new CurrencyFormatterService();
		boolean result = formatter.isValidValue(input);

		//then
		assertTrue(result);
	}

	@Test
	public void given_inputIsInvalid_when_isValid_then_error() {

		//given
		String input = "10.5 ";

		//when
		CurrencyFormatterService formatter = new CurrencyFormatterService();
		boolean result = formatter.isValidValue(input);

		//then
		assertFalse(result);
	}

	@Test
	public void given_inputIsNotDigit_when_isValid_then_error() {

		//given
		String input = "AAA EUR";

		//when
		CurrencyFormatterService formatter = new CurrencyFormatterService();
		boolean result = formatter.isValidValue(input);

		//then
		assertFalse(result);
	}

	@Test
	public void given_inputIsEmpty_when_isValid_then_error() {

		//given
		String input = "";

		//when
		CurrencyFormatterService formatter = new CurrencyFormatterService();
		boolean result = formatter.isValidValue(input);

		//then
		assertFalse(result);
	}

	@Test
	public void given_inputIsNull_when_isValid_then_error() {

		//given
		String input = null;

		//when
		CurrencyFormatterService formatter = new CurrencyFormatterService();
		boolean result = formatter.isValidValue(input);

		//then
		assertFalse(result);
	}

	@Test
	public void given_inputIsValid_when_format_then_success() {

		//given
		Currency currency = new Currency();
		currency.setValue(10.5);
		currency.setCode("EUR");

		//when
		CurrencyFormatterService formatter = new CurrencyFormatterService();
		FormatterResult<String> result = formatter.format(currency);

		//then
		assertEquals(FormatResultStatus.OK, result.getStatus());
		assertEquals("10.5 EUR", result.getResult());
	}

	@Test
	public void given_inputIsInvalid_when_format_then_error() {

		//given
		Currency currency = null;

		//when
		CurrencyFormatterService formatter = new CurrencyFormatterService();
		FormatterResult<String> result = formatter.format(currency);

		//then
		assertEquals(FormatResultStatus.ERROR, result.getStatus());
		assertTrue(!result.getMsg().isBlank());
	}

}
