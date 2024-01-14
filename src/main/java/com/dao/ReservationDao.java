package com.dao;
import java.util.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.entity.*;
@Repository
public class ReservationDao {
	@Autowired
	private SessionFactory sessionFactory;
	public int addReservation(Reservation r) {
		try {
			
			Session session=sessionFactory.openSession();
			session.beginTransaction();
			session.persist(r);
			session.getTransaction().commit();
			session.close();
			return 1;
		}
		catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	}

	public Reservation getResevationById(int id) {
		try {
			Session session=sessionFactory.openSession();
			return (Reservation)session.createQuery("from Reservation where id=:rid").setParameter("rid", id).getSingleResult();
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public List<Reservation> getResevationByName(String name) {
		try {
			Session session=sessionFactory.openSession();
			return session.createQuery("from Reservation where revservation_name=:name").setParameter("name", name).getResultList();
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public int cancelFlight(int id) {
		try {
			Session session=sessionFactory.openSession();
			
			Reservation r=(Reservation)session.createQuery("from Reservation where id=:rid").setParameter("rid", id).getSingleResult();
			if(r!=null) {
				session.beginTransaction();
				session.delete(r);
				session.getTransaction().commit();
				session.close();
				return 1;
			}
			
			return 0;
		}
		catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	public List<Reservation> getAllReservedFlights(){
		try {
			Session session=sessionFactory.openSession();
			return session.createQuery("from Reservation ").getResultList();
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
