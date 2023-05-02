/**
 * 
 */
package com.shz.formatter.service;

import org.springframework.stereotype.Service;

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
@Service
public class CurrencyFormatterService extends BaseFormatterService<Currency> {

	public CurrencyFormatterService() {
		super(new CurrencyValueValidator(new EmptyValueValidator()), new UpperCaseCurrCodeValueParser(new CurrencyValueParser()),
				new CurrencyValueFormatter());
	}

}
