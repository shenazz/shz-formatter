/**
 * 
 */
package com.shz.formatter.valueparser;

import com.shz.formatter.model.Email;

/**
 * @author shenazz
 *
 */
public class EmailValueParser implements ValueParser<Email> {

	@Override
	public Email parse(String inputValue) {
		Email email = new Email();
		email.setValue(inputValue);
		return email;
	}

}
