package com.ems.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ems.entity.Address;
import com.ems.entity.Event;
import com.ems.repository.AddressRepository;
import com.ems.repository.EventRepository;

@Service
public class AddressService {

	private final AddressRepository addressRepository;
	private final EventRepository eventRepository;

	public AddressService(AddressRepository addressRepository, EventRepository eventRepository) {
		this.addressRepository = addressRepository;
		this.eventRepository = eventRepository;
	}

	public void addAddress(Address address, int eventId) {
		Event existingEvent = eventRepository.findEventById(eventId);
		addressRepository.addAddress(address, existingEvent);
	}

	public List<String> findAllAddressesDistinctCities() {
		return addressRepository.findAllAddressesDistinctCities();
	}

	public Address findAddressById(int addressId) {
		return addressRepository.findAddressById(addressId);
	}

	public void updateAddress(Address address) {
		addressRepository.updateAddress(address);
	}

	public void deleteAddress(int addressId, int eventId) {
		Event event = eventRepository.findEventById(eventId);
		event.setAddress(null);
		eventRepository.updateEvent(event);

		addressRepository.deleteAddress(addressId);
	}
}
