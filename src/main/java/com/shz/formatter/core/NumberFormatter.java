/**
 * 
 */
package com.shz.formatter.core;

import com.shz.formatter.valueformatter.NumberValueFormatter;
import com.shz.formatter.valueparser.NumberValueParser;
import com.shz.formatter.valuevalidator.EmptyValueValidator;
import com.shz.formatter.valuevalidator.NumberValueValidator;

/**
 * @author shenazz
 *
 */
public class NumberFormatter extends BaseFormatter<Long> {

	public NumberFormatter() {
		super(new NumberValueValidator(new EmptyValueValidator()), new NumberValueParser(), new NumberValueFormatter());
	}
}
