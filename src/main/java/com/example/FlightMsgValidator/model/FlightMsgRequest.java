package com.example.FlightMsgValidator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightMsgRequest {

	public String messageType;
	public String flightNumber;
	
}
