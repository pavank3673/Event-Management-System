package com.ems.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ems.entity.Event;
import com.ems.service.AddressService;
import com.ems.service.EventService;

@Controller
public class EventController {

	private final EventService eventService;
	private final AddressService addressService;

	public EventController(EventService eventService,AddressService addressService) {
		this.eventService = eventService;
		this.addressService = addressService;
	}

	@RequestMapping("/")
	public ModelAndView home(@RequestParam(required = false) String cityParam) {
		List<String> cities = addressService.findAllAddressesDistinctCities();
		List<Event> events =  eventService.findEventsByCity(cityParam);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("home.jsp");
		mav.addObject("cities", cities);
		mav.addObject("cityValidator", new String());
		mav.addObject("events", events);

		return mav;
	}

	@RequestMapping("/add-event-view")
	public ModelAndView addEventView() {
		return new ModelAndView("add_event.jsp","event",new Event());
	}

	@RequestMapping(path = "/add-event", method = RequestMethod.POST)
	public ModelAndView addEvent(Event event) {
		eventService.addEvent(event);
		return new ModelAndView("redirect:/manage-events");
	}

	@RequestMapping("/manage-events")
	public ModelAndView findAllEvents() {
		List<Event> events = eventService.findAllEvents();
		return new ModelAndView("manage_events.jsp","events",events);
	}

	@RequestMapping("/request-update-event")
	public ModelAndView requestUpdateEvent(@RequestParam int eventId) {
		Event event = eventService.findEventById(eventId);
		return new ModelAndView("update_event.jsp","event",event);
	}

	@RequestMapping(path = "/update-event",method = RequestMethod.POST)
	public ModelAndView updateEvent(Event event) {
		eventService.updateEvent(event);
		return new ModelAndView("redirect:/manage-events");
	}

	@RequestMapping("/delete-event")
	public ModelAndView deleteEvent(@RequestParam int eventId) {
		eventService.deleteEvent(eventId);
		return new ModelAndView("redirect:/manage-events");
	}
}
