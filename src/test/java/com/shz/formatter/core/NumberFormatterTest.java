/**
 * 
 */
package com.shz.formatter.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.shz.formatter.model.FormatterResult;
import com.shz.formatter.model.FormatResultStatus;
import com.shz.formatter.service.NumberFormatterService;

/**
 * @author shenazz
 *
 */
public class NumberFormatterTest {

	@Test
	public void given_inputIsInteger_when_parse_then_success() {

		//given
		String input = "1";

		//when
		NumberFormatterService formatter = new NumberFormatterService();
		FormatterResult<Long> result = formatter.parse(input);

		assertEquals(FormatResultStatus.OK, result.getStatus());
		assertEquals(1, result.getResult());
	}

	@Test
	public void given_inputIsLong_when_parse_then_success() {

		//given
		String input = Long.toString(Long.MAX_VALUE);

		//when
		NumberFormatterService formatter = new NumberFormatterService();
		FormatterResult<Long> result = formatter.parse(input);

		//then
		assertEquals(FormatResultStatus.OK, result.getStatus());
		assertEquals(Long.MAX_VALUE, result.getResult());
	}

	@Test
	public void given_inputIsDouble_when_parse_then_error() {

		//given
		String input = Double.toString(Double.MAX_VALUE);

		//when
		NumberFormatterService formatter = new NumberFormatterService();
		FormatterResult<Long> result = formatter.parse(input);

		assertEquals(FormatResultStatus.ERROR, result.getStatus());
		assertTrue(!result.getMsg().isBlank());
	}

	@Test
	public void given_inputIsString_when_parse_then_error() {

		//given
		String input = "AAA";

		//when
		NumberFormatterService formatter = new NumberFormatterService();
		FormatterResult<Long> result = formatter.parse(input);

		//then
		assertEquals(FormatResultStatus.ERROR, result.getStatus());
		assertTrue(!result.getMsg().isBlank());
	}

	@Test
	public void given_inputIsInteger_when_isValid_then_success() {

		//given
		String input = "1";

		//when
		NumberFormatterService formatter = new NumberFormatterService();
		boolean result = formatter.isValidValue(input);

		//then
		assertTrue(result);
	}

	@Test
	public void given_inputIsLong_when_isValid_then_success() {

		//given
		String input = Long.toString(Long.MAX_VALUE);

		//when
		NumberFormatterService formatter = new NumberFormatterService();
		boolean result = formatter.isValidValue(input);

		//then
		assertTrue(result);
	}

	@Test
	public void given_inputIsDouble_when_isValid_then_error() {

		//given
		String input = Double.toString(Double.MAX_VALUE);

		//when
		NumberFormatterService formatter = new NumberFormatterService();
		boolean result = formatter.isValidValue(input);

		//then
		assertFalse(result);
	}

	@Test
	public void given_inputIsString_when_isValid_then_error() {

		//given
		String input = "AAA";

		//when
		NumberFormatterService formatter = new NumberFormatterService();
		boolean result = formatter.isValidValue(input);

		//then
		assertFalse(result);
	}

	@Test
	public void given_inputIsEmpty_when_isValid_then_error() {

		//given
		String input = "";

		//when
		NumberFormatterService formatter = new NumberFormatterService();
		boolean result = formatter.isValidValue(input);

		//then
		assertFalse(result);
	}

	@Test
	public void given_inputIsNull_when_isValid_then_error() {

		//given
		String input = null;

		//when
		NumberFormatterService formatter = new NumberFormatterService();
		boolean result = formatter.isValidValue(input);

		//then
		assertFalse(result);
	}

	@Test
	public void given_inputIsValid_when_format_then_success() {

		//given
		long input = 1l;

		//when
		NumberFormatterService formatter = new NumberFormatterService();
		FormatterResult<String> result = formatter.format(input);

		//then
		assertEquals(FormatResultStatus.OK, result.getStatus());
		assertEquals("1", result.getResult());
	}

	@Test
	public void given_inputIsInvalid_when_format_then_error() {

		//given
		Long input = null;

		//when
		NumberFormatterService formatter = new NumberFormatterService();
		FormatterResult<String> result = formatter.format(input);

		//then
		assertEquals(FormatResultStatus.ERROR, result.getStatus());
		assertTrue(!result.getMsg().isBlank());
	}
}
