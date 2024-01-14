package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.service.FlightService;
import com.entity.*;
import java.util.*;

@RestController
@CrossOrigin
public class FlightController {

	@Autowired
	private FlightService flightService;

	@GetMapping("/getFlight/all")
	public List<Flight> getAllFlight() {
		return this.flightService.getAllFlights();
	}
	@GetMapping("/getFlight/{id}")
	public Flight getAllFlight(@PathVariable int id) {
		return this.flightService.getFlight(id);
	}
	@GetMapping("/getFlightByDestination/{dest}")
	public Flight getAllFlight(@PathVariable String dest) {
		return this.flightService.getFlightByDestination(dest);
	}

	@PostMapping("/addFlight")
	public ResponseEntity<String> addAllFlights(@RequestBody Flight flight) {
		int a = this.flightService.addFlight(flight);
		if (a == 1) {
			return new ResponseEntity<>("Flight Added Successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Flight Not Added Due to some error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/addFlight/all")
	public ResponseEntity<String> addAllFlights(@RequestBody List<Flight> flights) {

		int a = this.flightService.addAllFlghits(flights);
		if (a == 1) {
			return new ResponseEntity<>("Flights Added Succcefully", HttpStatus.OK);

		}
		return new ResponseEntity<>("Flights NOt Added Due to Some error", HttpStatus.INTERNAL_SERVER_ERROR);

	}
	@PutMapping("/updateFlight/{id}")
	public ResponseEntity<String> updateFlight(@PathVariable int id,@RequestBody Flight flight){
		int a=this.flightService.updateFlight(id,flight);
		if(a==1) {
			return new ResponseEntity<>("Flight Updated Successfully",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Flight Not Updated due to Some error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
