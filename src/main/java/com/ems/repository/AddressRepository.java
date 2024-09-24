package com.ems.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.ems.entity.Address;
import com.ems.entity.Event;

@Repository
public class AddressRepository {

	private final EntityManagerFactory factory;

	public AddressRepository(EntityManagerFactory factory) {
		this.factory = factory;
	}

	public void addAddress(Address address, Event event) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		transaction.begin();
		manager.persist(address);

		event.setAddress(address);
		manager.merge(event);

		transaction.commit();

		manager.close();
	}

	public List<String> findAllAddressesDistinctCities() {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<String> query = manager.createQuery("SELECT DISTINCT(a.city) FROM Address a", String.class);
		List<String> addresses = query.getResultList();
		manager.close();

		return addresses;
	}

	public Address findAddressById(int addressId) {
		EntityManager manager = factory.createEntityManager();
		Address address = manager.find(Address.class, addressId);
		manager.close();

		return address;
	}

	public void updateAddress(Address address) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		transaction.begin();
		manager.merge(address);
		transaction.commit();

		manager.close();
	}

	public void deleteAddress(int addressId) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		transaction.begin();
		manager.remove(manager.find(Address.class, addressId));
		transaction.commit();

		manager.close();
	}
}
