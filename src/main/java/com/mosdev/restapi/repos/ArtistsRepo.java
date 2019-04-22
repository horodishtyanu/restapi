package com.mosdev.restapi.repos;

import com.mosdev.restapi.domain.Artists;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistsRepo extends JpaRepository<Artists, Long> {
}
