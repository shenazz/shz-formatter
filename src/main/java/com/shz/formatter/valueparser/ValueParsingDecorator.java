/**
 * 
 */
package com.shz.formatter.valueparser;

/**
 * @author shenazz
 *
 */
public abstract class ValueParsingDecorator<T> implements ValueParser<T> {

	private ValueParser<T> valueParser;

	public ValueParsingDecorator(ValueParser<T> valueParser) {
		this.valueParser = valueParser;
	}

	@Override
	public T parse(String inputValue) {

		inputValue = inputValue.trim();

		T parsedValue = this.valueParser.parse(inputValue);

		return this.selfParse(parsedValue);
	}

	/**
	 * @param inputValue
	 *            The input string to parse
	 * 
	 * @return The parsed object
	 */
	protected abstract T selfParse(T parsedValue);

}
