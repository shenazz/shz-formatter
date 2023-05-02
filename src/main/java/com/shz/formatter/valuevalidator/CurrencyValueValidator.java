/**
 * 
 */
package com.shz.formatter.valuevalidator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.shz.formatter.exception.InvalidValueException;
import com.shz.formatter.util.EmptyChecker;

/**
 * @author shenazz
 *
 */
public class CurrencyValueValidator extends ValueValidationDecorator {

	public CurrencyValueValidator(ValueValidator valueValidator) {
		super(valueValidator);
	}

	@Override
	public void selfValidate(String inputValue) throws InvalidValueException {

		String[] tokens = inputValue.split(" ");

		List<String> filteredTokens = Stream.of(tokens).filter(token -> !EmptyChecker.isEmpty(token)).collect(Collectors.toList());

		String errorMessage = "Please use correct currency format. Eg: 10 EUR";

		if (filteredTokens.size() != 2) {
			throw new InvalidValueException(errorMessage);
		}

		try {
			Double.parseDouble(filteredTokens.get(0));
		} catch (NumberFormatException e) {
			throw new InvalidValueException(errorMessage);
		}

	}
}
