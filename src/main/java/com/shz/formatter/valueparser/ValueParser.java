/**
 * 
 */
package com.shz.formatter.valueparser;

/**
 * @author shenazz
 *
 */
public interface ValueParser<T> {

	/**
	 * @param inputValue
	 *            The input string to parse
	 * 
	 * @return The parsed object
	 */
	public T parse(String inputValue);

}
