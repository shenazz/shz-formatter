/**
 * 
 */
package com.shz.formatter.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shz.formatter.model.FormatResult;

import io.swagger.annotations.ApiOperation;

/**
 * @author shenazz
 *
 */
@RestController
public class FormatController {

	@PostMapping(path = "/format-result")
	@ApiOperation(value = "Verify that the API is available", notes = "Used by monitoring tools to check the health status of this API.")
	public <T> FormatResult<T> format() {
		return null;
	}

}
