package com.ems.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.ems.entity.Event;

@Repository
public class EventRepository {

	private final EntityManagerFactory factory;

	public EventRepository(EntityManagerFactory factory) {
		this.factory = factory;
	}
	
	public void addEvent(Event event) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		transaction.begin();
		manager.persist(event);
		transaction.commit();
		
		manager.close();
	}

	public List<Event> findAllEvents() {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Event> query = manager.createQuery("FROM Event", Event.class);
		List<Event> events = query.getResultList();
		manager.close();

		return events;
	}
	
	public void deleteEvent(int eventId) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		transaction.begin();
		manager.remove(manager.find(Event.class, eventId));
		transaction.commit();
		
		manager.close();
	}
	
	public Event findEventById(int eventId) {
		EntityManager manager = factory.createEntityManager();
		Event event = manager.find(Event.class, eventId);
		manager.close();
		
		return event;
	}
	
	public void updateEvent(Event event) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		transaction.begin();
		manager.merge(event);
		transaction.commit();
		
		manager.close();
	}

	public List<Event> findEventsByCity(String city) {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Event> query = manager.createQuery("FROM Event e WHERE e.address IN (FROM Address a WHERE a.city=:city)", Event.class);
		query.setParameter("city", city);
		List<Event> events = query.getResultList();
		
		manager.close();
		
		return events;
	}
}
