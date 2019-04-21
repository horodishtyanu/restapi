package com.mosdev.restapi.repos;


import com.mosdev.restapi.domain.Events;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EventsRepo extends JpaRepository<Events, Long>{
   @Query("SELECT e from Events e where e.active = 'Y' ORDER BY e.sort ASC")
   List<Events> findAll();
}
