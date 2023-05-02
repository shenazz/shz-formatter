/**
 * 
 */
package com.shz.formatter.util;

/**
 * @author shenazz
 *
 */
public class EmptyChecker {

	/**
	 * @param value
	 *            to check
	 *            
	 * @return true if value is either null or blank
	 */
	public static boolean isEmpty(String value) {
		return value == null || value.isBlank();
	}

}
