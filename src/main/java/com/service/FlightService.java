package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.FlightDao;
import com.entity.*;
import java.util.*;
@Service
public class FlightService {
	@Autowired
	private FlightDao flightDao;
	public List<Flight> getAllFlights(){
		return this.flightDao.getAllFlight();
	}
	public Flight getFlight(int id) {
		return this.flightDao.getFlight(id);
	}
	public Flight getFlightByDestination(String dest) {
		return this.flightDao.getFlightByDestination(dest);
	}
	public int addFlight(Flight flight) {
		return this.flightDao.addFlight(flight);
	}
	public int addAllFlghits(List<Flight> flights) {
		return this.flightDao.addAllFlight(flights);
	}
	public int updateFlight(int id,Flight flight) {
		return this.flightDao.updateFlight(id,flight);
	}

}
