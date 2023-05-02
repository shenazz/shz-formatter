/**
 * 
 */
package com.shz.formatter.core;

import com.shz.formatter.model.FormatterResult;

/**
 * @author shenazz
 *
 */
public interface Formatter<T> {

	/**
	 * Parses the provided input string to the defined type
	 * 
	 * @param input
	 *            The input string to parse
	 * 
	 * @return FormatterResult with result status and the actual result object
	 */
	public FormatterResult<T> parse(String input);

	/**
	 * Returns the String representation of the input object
	 * 
	 * @param input
	 *            The input object to format
	 * 
	 * @return FormatterResult with result status and the actual result String
	 */
	public FormatterResult<String> format(T input);

	/**
	 * Validates if the input String is a valid representation of the defined type 
	 * 
	 * @param input
	 *            The input string to validate
	 *            
	 * @return True the input String matches the object format
	 */
	public boolean isValidValue(String input);

}
