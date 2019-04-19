package com.mosdev.restapi.repos;

import com.mosdev.restapi.domain.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizQuestRepo extends JpaRepository<Quiz, Long> {
}
