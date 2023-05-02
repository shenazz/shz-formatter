/**
 * 
 */
package com.shz.formatter.valueparser;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.shz.formatter.model.Currency;
import com.shz.formatter.util.EmptyChecker;

/**
 * @author shenazz
 *
 */
public class CurrencyValueParser implements ValueParser<Currency> {

	@Override
	public Currency parse(String inputValue) {

		List<String> tokens = Stream.of(inputValue.split(" ")).filter(token -> !EmptyChecker.isEmpty(token)).map(token -> token.trim())
				.collect(Collectors.toList());

		Double value = Double.valueOf(tokens.get(0));

		if (value < 1) {
			throw new RuntimeException("Value should be greater than 0");
		}

		String code = tokens.get(1);

		Currency currency = new Currency();
		currency.setValue(value);
		currency.setCode(code);

		return currency;
	}

}
