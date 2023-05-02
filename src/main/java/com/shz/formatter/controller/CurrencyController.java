/**
 * 
 */
package com.shz.formatter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shz.formatter.exception.InvalidValueException;
import com.shz.formatter.model.Currency;
import com.shz.formatter.service.CurrencyService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author shenazz
 *
 */
@RestController
@RequestMapping("/currency")
public class CurrencyController {

	@Autowired
	private CurrencyService currencyService;

	@GetMapping(path = "/latest-rates")
	@ApiOperation(value = "Fetch the latest rates", notes = "For the given input value, returns the currency rates in EUR, USD. GBP and INR. The input value should be of the format 'value' 'currency code' eg. 10 JPY.")
	public Currency formatCurrency(@ApiParam(value = "Input value", example = "10 JPY") @RequestParam String input)
			throws InvalidValueException {
		return currencyService.convert(input);
	}

}
