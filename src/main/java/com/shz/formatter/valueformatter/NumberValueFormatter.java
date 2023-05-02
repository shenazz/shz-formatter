/**
 * 
 */
package com.shz.formatter.valueformatter;

/**
 * @author shenazz
 *
 */
public class NumberValueFormatter implements ValueFormatter<Long> {

	@Override
	public String format(Long inputValue) {
		return inputValue.toString();
	}

}
