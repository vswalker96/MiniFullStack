package com.revature.minifullstack.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.minifullstack.exception.ResourceNotFoundException;
import com.revature.minifullstack.models.Event;
import com.revature.minifullstack.models.User;
import com.revature.minifullstack.repository.EventRepository;
import com.revature.minifullstack.service.TimeInWordsService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class EventController {
	
	@Autowired
	EventRepository eventRepository;
	
	@Autowired
	TimeInWordsService timeInWordsService;
	
	
	/* 
	 * create an event and call time in words service method 
	 */
	
	@PostMapping("/event")
	public Event createEvent(@RequestBody Event event) {
		return eventRepository.save(event);
	}
	
	@GetMapping("/event")
	public List<Event> getAllEvents() {
		List<Event> events = eventRepository.findAll();
		
		for (Event event: events) {
			int h = event.getHour();
			int m = event.getMinute();
			
			event.setTimeInWords(timeInWordsService.timeInWords(h, m));
		
		}
		
		return events;
	}
	
	@GetMapping("/event/{id}")
	public List<Event> getEventById(@PathVariable(value = "id") int eventId) {
		List<Event> events = eventRepository.findByEventId(eventId);
				
		
		for (Event event: events) {
			int h = event.getHour();
			int m = event.getMinute();
			
			event.setTimeInWords(timeInWordsService.timeInWords(h, m));
		
		}
		
		return events;
	}
	
	@GetMapping("/event/user/{id}")
	public List<Event> getEventByUserId(@PathVariable(value = "id") int userId) {
		List<Event> events = eventRepository.findByUserId(userId);
				
		
		for (Event event: events) {
			int h = event.getHour();
			int m = event.getMinute();
			
			event.setTimeInWords(timeInWordsService.timeInWords(h, m));
		
		}
		
		return events;
	}
	
	
	
	

}
