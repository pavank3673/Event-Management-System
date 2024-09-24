package com.ems.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "events")
public class Event {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "event_id")
		private int eventId;
		@Column(name = "title")
		private String title;
		@Column(name = "description")
		private String description;
		@Column(name = "start_datetime")
		private LocalDateTime startDateTime;
		@Column(name = "status")
		private String status;
		@OneToOne(cascade = CascadeType.REMOVE)
		@JoinColumn(name = "address")
		private Address address;
		
		public int getEventId() {
			return eventId;
		}
		public void setEventId(int eventId) {
			this.eventId = eventId;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public LocalDateTime getStartDateTime() {
			return startDateTime;
		}
		public void setStartDateTime(LocalDateTime startDateTime) {
			this.startDateTime = startDateTime;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public Address getAddress() {
			return address;
		}
		public void setAddress(Address address) {
			this.address = address;
		}
}
