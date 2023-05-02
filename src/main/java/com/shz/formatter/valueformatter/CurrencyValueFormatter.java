/**
 * 
 */
package com.shz.formatter.valueformatter;

import com.shz.formatter.model.Currency;
import com.shz.formatter.util.EmptyChecker;

/**
 * @author shenazz
 *
 */
public class CurrencyValueFormatter implements ValueFormatter<Currency> {

	@Override
	public String format(Currency inputValue) {
		StringBuilder builder = new StringBuilder();
		builder.append(inputValue.getValue());
		if (!EmptyChecker.isEmpty(inputValue.getCode())) {
			builder.append(" ");
			builder.append(inputValue.getCode().toUpperCase());
		}
		return builder.toString();
	}

}
