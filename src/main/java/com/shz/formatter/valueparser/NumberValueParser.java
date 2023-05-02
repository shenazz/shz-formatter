/**
 * 
 */
package com.shz.formatter.valueparser;

/**
 * @author shenazz
 *
 */
public class NumberValueParser implements ValueParser<Long> {

	@Override
	public Long parse(String inputValue) {
		return Long.parseLong(inputValue.trim());
	}

}
