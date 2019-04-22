package com.mosdev.restapi.repos;

import com.mosdev.restapi.domain.Leaders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeadersRepo extends JpaRepository<Leaders, Long> {
}
