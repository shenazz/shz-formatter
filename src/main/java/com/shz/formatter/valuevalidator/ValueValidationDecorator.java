package com.shz.formatter.valuevalidator;

import com.shz.formatter.exception.InvalidValueException;

/**
 * @author shenazz
 *
 */
public abstract class ValueValidationDecorator implements ValueValidator {

	private ValueValidator valueValidator;

	public ValueValidationDecorator(ValueValidator valueValidator) {
		this.valueValidator = valueValidator;
	}

	@Override
	public void validate(String inputValue) throws InvalidValueException {

		this.valueValidator.validate(inputValue);

		this.selfValidate(inputValue);

	}

	/**
	 * @param inputValue
	 *            The input string to validate
	 * 
	 * @throws InvalidValueException
	 *             If the input String does not match the object format
	 */
	protected abstract void selfValidate(String inputValue) throws InvalidValueException;

}
