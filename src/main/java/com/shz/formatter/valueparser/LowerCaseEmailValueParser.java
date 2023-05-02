package com.shz.formatter.valueparser;

import com.shz.formatter.model.Email;
import com.shz.formatter.util.EmptyChecker;

/**
 * @author shenazz
 *
 */
public class LowerCaseEmailValueParser extends ValueParsingDecorator<Email> {

	public LowerCaseEmailValueParser(ValueParser<Email> valueParser) {
		super(valueParser);
	}

	@Override
	protected Email selfParse(Email parsedValue) {
		if (parsedValue != null && !EmptyChecker.isEmpty(parsedValue.getValue())) {
			parsedValue.setValue(parsedValue.getValue().toLowerCase());
		}

		return parsedValue;
	}

}
