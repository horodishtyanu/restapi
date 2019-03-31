package com.mosdev.restapi.repos;

import com.mosdev.restapi.domain.Affiche;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AfficheRepo extends JpaRepository<Affiche, Long> {
}
