/**
 * 
 */
package com.shz.formatter.service;

import org.springframework.stereotype.Service;

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
@Service
public class EmailFormatterService extends BaseFormatterService<Email> {

	public EmailFormatterService() {
		super(new RegexValueValidator(new EmptyValueValidator(), "^(.+)@(\\S+)$"), new LowerCaseEmailValueParser(new EmailValueParser()),
				new EmailValueFormatter());
	}
}
