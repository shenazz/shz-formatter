/**
 * 
 */
package com.shz.formatter.valueformatter;

import com.shz.formatter.model.Email;

/**
 * @author shenazz
 *
 */
public class EmailValueFormatter implements ValueFormatter<Email> {

	@Override
	public String format(Email inputValue) {
		return inputValue.getValue();
	}

}
