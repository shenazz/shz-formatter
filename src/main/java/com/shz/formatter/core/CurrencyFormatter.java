/**
 * 
 */
package com.shz.formatter.core;

import com.shz.formatter.model.Currency;
import com.shz.formatter.valueformatter.CurrencyValueFormatter;
import com.shz.formatter.valueparser.CurrencyValueParser;
import com.shz.formatter.valueparser.UpperCaseCurrCodeValueParser;
import com.shz.formatter.valuevalidator.CurrencyValueValidator;
import com.shz.formatter.valuevalidator.EmptyValueValidator;

/**
 * @author shenazz
 *
 */
public class CurrencyFormatter extends BaseFormatter<Currency> {

	public CurrencyFormatter() {
		super(new CurrencyValueValidator(new EmptyValueValidator()), new UpperCaseCurrCodeValueParser(new CurrencyValueParser()),
				new CurrencyValueFormatter());
	}

}
