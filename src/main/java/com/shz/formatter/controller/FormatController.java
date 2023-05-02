/**
 * 
 */
package com.shz.formatter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shz.formatter.model.Currency;
import com.shz.formatter.model.FormatterResult;
import com.shz.formatter.service.CurrencyFormatterService;

import io.swagger.annotations.ApiOperation;

/**
 * @author shenazz
 *
 */
@RestController
public class FormatController {

	@Autowired
	private CurrencyFormatterService currencyFormatterSevice;

	@PostMapping(path = "/currency-format-result")
	@ApiOperation(value = "Verify that the API is available", notes = "Used by monitoring tools to check the health status of this API.")
	public FormatterResult<String> formatCurrency(@RequestBody Currency currency) {
		return currencyFormatterSevice.format(currency);
	}

	@PostMapping(path = "/currency-parse-result")
	@ApiOperation(value = "Verify that the API is available", notes = "Used by monitoring tools to check the health status of this API.")
	public FormatterResult<Currency> formatCurrency(@RequestBody String value) {
		return currencyFormatterSevice.parse(value);
	}

}
