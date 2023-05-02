/**
 * 
 */
package com.shz.formatter.valuevalidator;

import com.shz.formatter.exception.InvalidValueException;
import com.shz.formatter.util.EmptyChecker;

/**
 * @author shenazz
 *
 */
public class EmptyValueValidator implements ValueValidator {

	@Override
	public void validate(String inputValue) throws InvalidValueException {

		if (EmptyChecker.isEmpty(inputValue)) {
			throw new InvalidValueException("Input value cannot be empty");
		}

	}

}
