/**
 * 
 */
package com.shz.formatter.service;

import com.shz.formatter.exception.InvalidValueException;
import com.shz.formatter.model.Currency;

/**
 * @author shenazz
 *
 */
public interface CurrencyService {

	public Currency convert(String input) throws InvalidValueException;

}
