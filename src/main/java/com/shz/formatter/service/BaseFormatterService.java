/**
 * 
 */
package com.shz.formatter.service;

import com.shz.formatter.exception.InvalidValueException;
import com.shz.formatter.model.FormatResult;
import com.shz.formatter.model.FormatResultStatus;
import com.shz.formatter.valueformatter.ValueFormatter;
import com.shz.formatter.valueparser.ValueParser;
import com.shz.formatter.valuevalidator.ValueValidator;

/**
 * @author shenazz
 *
 */
public abstract class BaseFormatterService<T> implements Formatter<T> {

	protected ValueValidator valueValidator;

	protected ValueParser<T> valueParser;

	protected ValueFormatter<T> valueFormatter;

	BaseFormatterService(ValueValidator valueValidator, ValueParser<T> valueParser, ValueFormatter<T> valueFormatter) {
		this.valueValidator = valueValidator;
		this.valueParser = valueParser;
		this.valueFormatter = valueFormatter;
	}

	@Override
	public FormatResult<T> parse(String inputValue) {
		FormatResult<T> result = new FormatResult<>();
		try {
			valueValidator.validate(inputValue);

			T parsedObject = valueParser.parse(inputValue);

			result.setStatus(FormatResultStatus.OK);
			result.setResult(parsedObject);
			result.setMsg("Parsing successful");
		} catch (Exception e) {
			result.setStatus(FormatResultStatus.ERROR);
			result.setMsg(getErrorMsg(e));
		}

		return result;
	}

	@Override
	public FormatResult<String> format(T inputValue) {
		FormatResult<String> result = new FormatResult<>();
		try {
			String formattedValue = this.valueFormatter.format(inputValue);

			result.setStatus(FormatResultStatus.OK);
			result.setResult(formattedValue);
			result.setMsg("Formatting successful");
		} catch (Exception e) {
			result.setStatus(FormatResultStatus.ERROR);
			result.setMsg(getErrorMsg(e));
		}
		return result;
	}

	@Override
	public boolean isValidValue(String inputValue) {
		boolean valid = false;
		try {
			valueValidator.validate(inputValue);
			valid = true;
		} catch (InvalidValueException e) {
		}

		return valid;
	}

	/**
	 * @return the valueValidator
	 */
	public ValueValidator getValueValidator() {
		return valueValidator;
	}

	/**
	 * @param valueValidator
	 *            the valueValidator to set
	 */
	public void setValueValidator(ValueValidator valueValidator) {
		this.valueValidator = valueValidator;
	}

	/**
	 * @return the valueParser
	 */
	public ValueParser<T> getValueParser() {
		return valueParser;
	}

	/**
	 * @param valueParser
	 *            the valueParser to set
	 */
	public void setValueParser(ValueParser<T> valueParser) {
		this.valueParser = valueParser;
	}

	/**
	 * @return the valueFormatter
	 */
	public ValueFormatter<T> getValueFormatter() {
		return valueFormatter;
	}

	/**
	 * @param valueFormatter
	 *            the valueFormatter to set
	 */
	public void setValueFormatter(ValueFormatter<T> valueFormatter) {
		this.valueFormatter = valueFormatter;
	}

	private String getErrorMsg(Exception e) {
		return e.getMessage() != null ? e.getMessage() : e.getClass().getName();
	}

}
