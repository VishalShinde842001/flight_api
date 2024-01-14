package com.service;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.*;
import com.entity.*;
@Service
public class ReservationService {
	@Autowired
	private ReservationDao reservationDao;
	public int addReservation(Reservation r) {
		return this.reservationDao.addReservation(r);
	}

	public Reservation getReservationById(int id) {
		return this.reservationDao.getResevationById(id);
	}
	public List<Reservation> getReservationByName(String name){
		return this.reservationDao.getResevationByName(name);
	}
	public int cancelFlight(int id) {
		return this.reservationDao.cancelFlight(id);
	}
	public List<Reservation> getAllReservedFlights(){
		return this.reservationDao.getAllReservedFlights();	}
}
