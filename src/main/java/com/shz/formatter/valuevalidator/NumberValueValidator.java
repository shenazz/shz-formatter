/**
 * 
 */
package com.shz.formatter.valuevalidator;

import com.shz.formatter.exception.InvalidValueException;

/**
 * @author shenazz
 *
 */
public class NumberValueValidator extends ValueValidationDecorator {

	public NumberValueValidator(ValueValidator valueValidator) {
		super(valueValidator);
	}

	@Override
	protected void selfValidate(String value) throws InvalidValueException {
		try {
			Long.parseLong(value.trim());
		} catch (NumberFormatException e) {
			throw new InvalidValueException(String.format("%s is not a long or int", value));
		}
	}

}
