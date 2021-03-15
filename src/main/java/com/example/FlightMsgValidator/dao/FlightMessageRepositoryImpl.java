package com.example.FlightMsgValidator.dao;

import java.util.Iterator;

import org.springframework.stereotype.Component;

import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazonaws.services.dynamodbv2.document.QueryOutcome;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class FlightMessageRepositoryImpl
implements IFlightMessageRepository{
	
	
	private DynamoDB dynamoDbOrDaxClient;
	 
    private String DYNAMODB_TABLE_NAME = "Flight";
    public FlightMessageRepositoryImpl(DynamoDB dbClient) {
    	this.dynamoDbOrDaxClient = dbClient;
    }

	@Override
	public boolean validateFlightMsg(String flightNumber) {
		log.info("getting flight");
		boolean isValid = false;
		QuerySpec spec  = new QuerySpec().
				withKeyConditionExpression("flightNo = :flight_no").
				withValueMap(new ValueMap()
						.withString(":flight_no", flightNumber));
		ItemCollection<QueryOutcome> items = this.dynamoDbOrDaxClient.
				getTable(DYNAMODB_TABLE_NAME).query(spec);
		
		Iterator<Item> iterator = items.iterator();
		while (iterator.hasNext()) {
		  Item item = iterator.next();
		  log.info(String.valueOf("name of flight::"+item.get("name")));
		  isValid = true;
		}
		
		return isValid;
	}
	
	

}
