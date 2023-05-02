/**
 * 
 */
package com.shz.formatter.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.shz.formatter.model.Email;
import com.shz.formatter.model.FormatResult;
import com.shz.formatter.model.FormatResultStatus;
import com.shz.formatter.service.EmailFormatterService;

/**
 * @author shenazz
 *
 */
public class EmailFormatterTest {

	@Test
	public void given_inputIsValid_when_parse_then_success() {

		//given
		String input = "aaa@aaa.com";

		//when
		EmailFormatterService formatter = new EmailFormatterService();
		FormatResult<Email> result = formatter.parse(input);

		assertEquals(FormatResultStatus.OK, result.getStatus());
		assertEquals(input, result.getResult().getValue());
	}

	@Test
	public void given_inputIsNotLowerCase_when_parse_then_successWithLowerCase() {

		//given
		String input = "AAa@aAa.com";

		//when
		EmailFormatterService formatter = new EmailFormatterService();
		FormatResult<Email> result = formatter.parse(input);

		assertEquals(FormatResultStatus.OK, result.getStatus());
		assertEquals(input.toLowerCase(), result.getResult().getValue());
	}

	@Test
	public void given_inputIsEmpty_when_parse_then_error() {

		//given
		String input = "";

		//when
		EmailFormatterService formatter = new EmailFormatterService();
		FormatResult<Email> result = formatter.parse(input);

		assertEquals(FormatResultStatus.ERROR, result.getStatus());
		assertTrue(!result.getMsg().isBlank());
	}

	
	@Test
	public void given_inputIsNull_when_parse_then_error() {

		//given
		String input = null;

		//when
		EmailFormatterService formatter = new EmailFormatterService();
		FormatResult<Email> result = formatter.parse(input);

		assertEquals(FormatResultStatus.ERROR, result.getStatus());
		assertTrue(!result.getMsg().isBlank());
	}
	
	@Test
	public void given_inputIsInvalid_when_parse_then_error() {

		//given
		String input = "AAA";

		//when
		EmailFormatterService formatter = new EmailFormatterService();
		FormatResult<Email> result = formatter.parse(input);

		assertEquals(FormatResultStatus.ERROR, result.getStatus());
		assertTrue(!result.getMsg().isBlank());
	}


	@Test
	public void given_inputIsValid_when_isValid_then_success() {

		//given
		String input = "aaa@aaa.com";

		//when
		EmailFormatterService formatter = new EmailFormatterService();
		boolean result = formatter.isValidValue(input);

		//then
		assertTrue(result);
	}

	@Test
	public void given_inputIsNull_when_isValid_then_error() {

		//given
		String input = null;

		//when
		EmailFormatterService formatter = new EmailFormatterService();
		boolean result = formatter.isValidValue(input);

		//then
		assertFalse(result);
	}

	@Test
	public void given_inputIsEmpty_when_isValid_then_error() {

		//given
		String input = "";

		//when
		EmailFormatterService formatter = new EmailFormatterService();
		boolean result = formatter.isValidValue(input);

		//then
		assertFalse(result);
	}

	@Test
	public void given_inputIsInvalidFormat_when_isValid_then_error() {

		//given
		String input = "AAA";

		//when
		EmailFormatterService formatter = new EmailFormatterService();
		boolean result = formatter.isValidValue(input);

		//then
		assertFalse(result);
	}

	@Test
	public void given_inputIsValid_when_format_then_success() {

		//given
		Email input = new Email();
		String emailValue = "aa@aa.com";
		input.setValue(emailValue);

		//when
		EmailFormatterService formatter = new EmailFormatterService();
		FormatResult<String> result = formatter.format(input);

		//then
		assertEquals(FormatResultStatus.OK, result.getStatus());
		assertEquals(emailValue, result.getResult());
	}

	@Test
	public void given_inputEmailValueIsNull_when_format_then_success() {

		//given
		Email input = new Email();

		//when
		EmailFormatterService formatter = new EmailFormatterService();
		FormatResult<String> result = formatter.format(input);

		//then
		assertEquals(FormatResultStatus.OK, result.getStatus());
		assertNull(result.getResult());
	}

	@Test
	public void given_inputValueIsNull_when_format_then_error() {

		//given
		Email input = null;

		//when
		EmailFormatterService formatter = new EmailFormatterService();
		FormatResult<String> result = formatter.format(input);

		//then
		assertEquals(FormatResultStatus.ERROR, result.getStatus());
		assertTrue(!result.getMsg().isBlank());
	}
}
