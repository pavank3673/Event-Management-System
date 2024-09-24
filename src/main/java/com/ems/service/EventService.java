package com.ems.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ems.entity.Event;
import com.ems.repository.EventRepository;

@Service
public class EventService {

	private final EventRepository eventRepository;

	public EventService(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}

	public void addEvent(Event event) {
		event.setStartDateTime(LocalDateTime.now());
		eventRepository.addEvent(event);
	}

	public List<Event> findAllEvents() {
		return eventRepository.findAllEvents();
	}

	public Event findEventById(int eventId) {
		return eventRepository.findEventById(eventId);
	}

	public void updateEvent(Event event) {
		Event existingEvent = eventRepository.findEventById(event.getEventId());
		existingEvent.setTitle(event.getTitle());
		existingEvent.setDescription(event.getDescription());
		existingEvent.setStatus(event.getStatus());

		eventRepository.updateEvent(existingEvent);
	}

	public void deleteEvent(int eventId) {
		eventRepository.deleteEvent(eventId);
	}

	public List<Event> findEventsByCity(String city) {
		if (city != null) {
			return eventRepository.findEventsByCity(city);
		}
		return null;
	}
}
