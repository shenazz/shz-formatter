/**
 * 
 */
package com.shz.formatter.valueformatter;

/**
 * @author shenazz
 *
 */
public interface ValueFormatter<T> {

	/**
	 * @param inputValue
	 *            The input object to format
	 * 
	 * @return String representation of the input object
	 */
	public String format(T inputValue);

}
