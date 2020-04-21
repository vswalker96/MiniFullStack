package com.revature.minifullstack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.revature.minifullstack.models.Event;

public interface EventRepository extends JpaRepository<Event, Integer> {
	
	@Query(value="SELECT * FROM EVENTS p WHERE p.event_id = :eventId",
			   nativeQuery=true)
	    public List<Event> findByEventId(@Param("eventId") int eventId);
	
	@Query(value="SELECT * FROM EVENTS p WHERE p.user_id = :userId",
			   nativeQuery=true)
	    public List<Event> findByUserId(@Param("userId") int userId);

}
