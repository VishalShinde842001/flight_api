package com.controller;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.entity.*;
import com.service.ReservationService;

@RestController
@CrossOrigin
public class RevservationController {
	@Autowired
	private ReservationService reservationService;

	@PostMapping("/addReservation")
	public ResponseEntity<String> addReservation(@RequestBody Reservation r) {
		int a = this.reservationService.addReservation(r);
		if (a == 1) {
			return new ResponseEntity<>("Reservation Done", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Reservation Not done", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/getReservationById/{id}")
	public ResponseEntity<Reservation> getResevationById(@PathVariable int id){
		Reservation r=this.reservationService.getReservationById(id);
		if(r!=null) {
			return new ResponseEntity<>((r),HttpStatus.OK);
		}else {
			return new ResponseEntity<>(r,HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/getReservationByName/{name}")
	public ResponseEntity<List<Reservation>> getResevationByName(@PathVariable String name){
		List<Reservation> r=this.reservationService.getReservationByName(name);
		if(r!=null) {
			return new ResponseEntity<>((r),HttpStatus.OK);
		}else {
			return new ResponseEntity<>(r,HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping("/cancelFlight/{id}")
	public ResponseEntity<String> cancelFlight(@PathVariable int id){
		int a=this.reservationService.cancelFlight(id);
		if(a==1) {
			return new ResponseEntity<>("Flight cancelled Successfully",HttpStatus.ACCEPTED);
		}else {
			return new ResponseEntity<>("Flghit Id not found",HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/getReservedFlight/all")
	public List<Reservation> getAllReservedFlights(){
		List<Reservation> r=this.reservationService.getAllReservedFlights();
		if(r!=null) {
			return r;
		}
		return null;
	}
	

}
