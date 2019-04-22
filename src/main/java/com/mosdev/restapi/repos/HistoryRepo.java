package com.mosdev.restapi.repos;

import com.mosdev.restapi.domain.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepo extends JpaRepository<History, Long> {
}
