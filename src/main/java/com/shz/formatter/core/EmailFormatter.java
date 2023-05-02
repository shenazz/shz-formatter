/**
 * 
 */
package com.shz.formatter.core;

import com.shz.formatter.model.Email;
import com.shz.formatter.valueformatter.EmailValueFormatter;
import com.shz.formatter.valueparser.EmailValueParser;
import com.shz.formatter.valueparser.LowerCaseEmailValueParser;
import com.shz.formatter.valuevalidator.EmptyValueValidator;
import com.shz.formatter.valuevalidator.RegexValueValidator;

/**
 * @author shenazz
 *
 */
public class EmailFormatter extends BaseFormatter<Email> {

	public EmailFormatter() {
		super(new RegexValueValidator(new EmptyValueValidator(), "^(.+)@(\\S+)$"), new LowerCaseEmailValueParser(new EmailValueParser()),
				new EmailValueFormatter());
	}
}
