/**
 * 
 */
package com.shz.formatter.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.shz.formatter.model.FormatterResult;
import com.shz.formatter.model.FormatterResult.ResultStatus;

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
		NumberFormatter formatter = new NumberFormatter();
		FormatterResult<Long> result = formatter.parse(input);

		assertEquals(ResultStatus.OK, result.getResultStatus());
		assertEquals(1, result.getResult());
	}

	@Test
	public void given_inputIsLong_when_parse_then_success() {

		//given
		String input = Long.toString(Long.MAX_VALUE);

		//when
		NumberFormatter formatter = new NumberFormatter();
		FormatterResult<Long> result = formatter.parse(input);

		//then
		assertEquals(ResultStatus.OK, result.getResultStatus());
		assertEquals(Long.MAX_VALUE, result.getResult());
	}

	@Test
	public void given_inputIsDouble_when_parse_then_error() {

		//given
		String input = Double.toString(Double.MAX_VALUE);

		//when
		NumberFormatter formatter = new NumberFormatter();
		FormatterResult<Long> result = formatter.parse(input);

		assertEquals(ResultStatus.ERROR, result.getResultStatus());
		assertTrue(!result.getMsg().isBlank());
	}

	@Test
	public void given_inputIsString_when_parse_then_error() {

		//given
		String input = "AAA";

		//when
		NumberFormatter formatter = new NumberFormatter();
		FormatterResult<Long> result = formatter.parse(input);

		//then
		assertEquals(ResultStatus.ERROR, result.getResultStatus());
		assertTrue(!result.getMsg().isBlank());
	}

	@Test
	public void given_inputIsInteger_when_isValid_then_success() {

		//given
		String input = "1";

		//when
		NumberFormatter formatter = new NumberFormatter();
		boolean result = formatter.isValidValue(input);

		//then
		assertTrue(result);
	}

	@Test
	public void given_inputIsLong_when_isValid_then_success() {

		//given
		String input = Long.toString(Long.MAX_VALUE);

		//when
		NumberFormatter formatter = new NumberFormatter();
		boolean result = formatter.isValidValue(input);

		//then
		assertTrue(result);
	}

	@Test
	public void given_inputIsDouble_when_isValid_then_error() {

		//given
		String input = Double.toString(Double.MAX_VALUE);

		//when
		NumberFormatter formatter = new NumberFormatter();
		boolean result = formatter.isValidValue(input);

		//then
		assertFalse(result);
	}

	@Test
	public void given_inputIsString_when_isValid_then_error() {

		//given
		String input = "AAA";

		//when
		NumberFormatter formatter = new NumberFormatter();
		boolean result = formatter.isValidValue(input);

		//then
		assertFalse(result);
	}
	
	@Test
	public void given_inputIsEmpty_when_isValid_then_error() {

		//given
		String input = "";

		//when
		NumberFormatter formatter = new NumberFormatter();
		boolean result = formatter.isValidValue(input);

		//then
		assertFalse(result);
	}
	
	@Test
	public void given_inputIsNull_when_isValid_then_error() {

		//given
		String input = null;

		//when
		NumberFormatter formatter = new NumberFormatter();
		boolean result = formatter.isValidValue(input);

		//then
		assertFalse(result);
	}

	@Test
	public void given_inputIsValid_when_format_then_success() {

		//given
		long input = 1l;

		//when
		NumberFormatter formatter = new NumberFormatter();
		FormatterResult<String> result = formatter.format(input);

		//then
		assertEquals(ResultStatus.OK, result.getResultStatus());
		assertEquals("1", result.getResult());
	}

	@Test
	public void given_inputIsInvalid_when_format_then_error() {

		//given
		Long input = null;
		
		//when
		NumberFormatter formatter = new NumberFormatter();
		FormatterResult<String> result = formatter.format(input);

		//then
		assertEquals(ResultStatus.ERROR, result.getResultStatus());
		assertTrue(!result.getMsg().isBlank());
	}
}
