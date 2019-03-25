package com.mosdev.restapi.repos;

import com.mosdev.restapi.domain.Affiche;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AfficheRepo extends CrudRepository<Affiche, Long> {
    List<Affiche> findById(Integer id);
}
