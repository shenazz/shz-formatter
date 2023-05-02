/**
 * 
 */
package com.shz.formatter.valuevalidator;

import com.shz.formatter.exception.InvalidValueException;

/**
 * @author shenazz
 *
 */
public interface ValueValidator {

	/**
	 * @param inputValue
	 *            The input string to validate
	 * 
	 * @throws InvalidValueException
	 *             If the input String does not match the object format
	 */
	public void validate(String inputValue) throws InvalidValueException;

}
