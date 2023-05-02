/**
 * 
 */
package com.shz.formatter.valueformatter;

/**
 * @author shenazz
 *
 */
public abstract class ValueFormationDecorator<T> implements ValueFormatter<T> {

	private ValueFormatter<T> valueFormatter;

	public ValueFormationDecorator(ValueFormatter<T> valueFormatter) {
		this.valueFormatter = valueFormatter;
	}

	@Override
	public String format(T inputValue) {
		String formattedValue = valueFormatter.format(inputValue);

		return selfFormat(formattedValue);
	}

	/**
	 * @param inputValue
	 *            The input object to format
	 * 
	 * @return String representation of the input object
	 */
	protected abstract String selfFormat(String formattedValue);

}
