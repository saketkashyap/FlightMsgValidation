package com.example.FlightMsgValidator.service;

import org.springframework.stereotype.Service;

import com.example.FlightMsgValidator.dao.IFlightMessageRepository;
import com.example.FlightMsgValidator.model.FlightMsgRequest;

@Service
public class ValidateFlightMsgService {

	
	private IFlightMessageRepository flightMsgRepository;
	
	public ValidateFlightMsgService(IFlightMessageRepository flightMsgRepository) {
		this.flightMsgRepository = flightMsgRepository;
	}
	
	public boolean checkIfFlightExistsByFlightNo(FlightMsgRequest request) {
		return flightMsgRepository.validateFlightMsg(request.getFlightNumber());
	}
}
