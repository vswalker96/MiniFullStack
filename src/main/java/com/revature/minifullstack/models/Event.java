package com.revature.minifullstack.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="events")
public class Event {
	
	@Id
	@Column(name ="event_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int eventId;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User userId;
	
	
	
	@Column(name="event_name")
	private String name;
	
	@Column(name="street")
	private String street;
	
	@Column(name="city")
	private String city;
	
	@Column(name="zip")
	private int zip;
	
	@Column(name="hour")
	private int hour;
	@Column(name="minute")
	private int minute;
	
	@Column(name="time_in_words")
	private String timeInWords;
	
	
	
	
	public Event() {}
	
	
	public Event(int eventId, User userId, String name, String street, String city, int zip, int hour, int minute, String timeInWords) {
		super();
		this.eventId = eventId;
		this.userId = userId;
		this.name = name;
		this.street = street;
		this.city = city;
		this.zip = zip;
		this.hour = hour;
		this.minute = minute;
		this.timeInWords = timeInWords;
	}
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public User getUserId() {
		return userId;
	}
	public void setUserId(User userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}


	public String getTimeInWords() {
		return timeInWords;
	}


	public void setTimeInWords(String timeInWords) {
		this.timeInWords = timeInWords;
	}
	
	


	
	
	

}
