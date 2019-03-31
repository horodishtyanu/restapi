package com.mosdev.restapi.repos;

import com.mosdev.restapi.domain.Affiche;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AfficheRepo extends JpaRepository<Affiche, Long> {
    Affiche findById(Integer id);
}
