/**
 * 
 */
package com.shz.formatter.valuevalidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.shz.formatter.exception.InvalidValueException;

/**
 * @author shenazz
 *
 */
public class RegexValueValidator extends ValueValidationDecorator {

	private String regex;

	public RegexValueValidator(ValueValidator valueValidator, String regex) {
		super(valueValidator);
		this.regex = regex;
	}

	@Override
	public void selfValidate(String inputValue) throws InvalidValueException {

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(inputValue);
		if (!matcher.matches()) {
			throw new InvalidValueException(String.format("Value must match the pattern '%s'", regex));
		}

	}
}
