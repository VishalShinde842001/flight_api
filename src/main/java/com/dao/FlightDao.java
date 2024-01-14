package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import com.entity.*;

@Repository
public class FlightDao {
	@Autowired
	private SessionFactory sessionFactory;

	public List<Flight> getAllFlight() {
		Session session = sessionFactory.openSession();
		String query = "from Flight";
		Query<Flight> q = session.createQuery(query);
		return q.getResultList();
	}
	public Flight getFlight(int id) {
		Session session=sessionFactory.openSession();
		return (Flight)session.createQuery("from Flight where id=:fid").setParameter("fid", id).getSingleResult();
	}
	public Flight getFlightByDestination(String dest) {
		Session session=sessionFactory.openSession();
		return (Flight)session.createQuery("from Flight where destination_city=:dest").setParameter("dest", dest).getSingleResult();
	}

	public int addFlight(Flight flight) {
		try{Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(flight);
		tx.commit();
		session.close();
		return 1;
		}
		catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int addAllFlight(List<Flight> flights) {
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			for (Flight f : flights) {
				session.save(f);
			}
			tx.commit();
			session.close();
			return 1;
			

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	public int updateFlight(int id,Flight flight) {
		try {
			Session session=sessionFactory.openSession();
			String hql="from Flight where id=:fid";
			Query q=session.createQuery(hql).setParameter("fid", id);
			Flight f=(Flight)q.getSingleResult();
			f.setDeparture_city(flight.getDeparture_city());
			f.setDestination_city(flight.getDestination_city());
			f.setDeparture_time(flight.getDeparture_time());
			f.setTicket_price(flight.getTicket_price());
			session.beginTransaction();
			session.save(f);
			session.getTransaction().commit();
			session.close();
			return 1;
			
		}
		catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

}
