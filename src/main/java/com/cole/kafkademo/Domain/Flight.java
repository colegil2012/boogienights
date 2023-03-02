package com.cole.kafkademo.Domain;

import org.json.JSONObject;

public class Flight {
	
	private String flightNr;
	private String destination;
	private String origin;
	
	
	public Flight(String flightNr, String destination, String origin) {
		this.flightNr = flightNr;
		this.destination = destination;
		this.origin = origin;
	}
	
	public Flight(String flightNr) {
		this.flightNr = flightNr;
	}
	
	public Flight() {
		this.flightNr = "000";
	}
	
	public JSONObject returnJSON() {
		JSONObject flight = new JSONObject();
				flight.put("flightNr", flightNr);
				flight.put("destination", destination);
				flight.put("origin", origin);
		
		return flight;
	}
	
	public String getFlightNr() {
		return flightNr;
	}
	public void setFlightNr(String flightNr) {
		this.flightNr = flightNr;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	
	
}
