package com.mosdev.restapi.repos;

import com.mosdev.restapi.domain.Events;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventsRepo extends JpaRepository<Events, Long> {
}
