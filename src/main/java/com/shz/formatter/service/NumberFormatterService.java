/**
 * 
 */
package com.shz.formatter.service;

import com.shz.formatter.valueformatter.NumberValueFormatter;
import com.shz.formatter.valueparser.NumberValueParser;
import com.shz.formatter.valuevalidator.EmptyValueValidator;
import com.shz.formatter.valuevalidator.NumberValueValidator;

/**
 * @author shenazz
 *
 */
public class NumberFormatterService extends BaseFormatterService<Long> {

	public NumberFormatterService() {
		super(new NumberValueValidator(new EmptyValueValidator()), new NumberValueParser(), new NumberValueFormatter());
	}
}
