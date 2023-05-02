package com.shz.formatter.valueparser;

import com.shz.formatter.model.Currency;
import com.shz.formatter.util.EmptyChecker;

/**
 * @author shenazz
 *
 */
public class UpperCaseCurrCodeValueParser extends ValueParsingDecorator<Currency> {

	public UpperCaseCurrCodeValueParser(ValueParser<Currency> valueParser) {
		super(valueParser);
	}

	@Override
	protected Currency selfParse(Currency parsedValue) {
		if (parsedValue != null && !EmptyChecker.isEmpty(parsedValue.getCode())) {
			parsedValue.setCode(parsedValue.getCode().toUpperCase());
		}

		return parsedValue;
	}

}
