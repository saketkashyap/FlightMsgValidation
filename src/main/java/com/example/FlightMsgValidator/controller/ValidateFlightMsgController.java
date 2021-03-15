package com.example.FlightMsgValidator.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.FlightMsgValidator.model.FlightMsgRequest;
import com.example.FlightMsgValidator.service.ValidateFlightMsgService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/flight")
@Slf4j
public class ValidateFlightMsgController {
	
	private ValidateFlightMsgService flightMsgValidationService;
	
	public ValidateFlightMsgController(ValidateFlightMsgService flightMsgValidationService) {
		this.flightMsgValidationService = flightMsgValidationService;
	}

	@PostMapping("/validate")
	public boolean validateFlightMsg(@RequestBody FlightMsgRequest
			request) {
		log.info("received request::"+request);
		return flightMsgValidationService.checkIfFlightExistsByFlightNo(request);
	}
}
