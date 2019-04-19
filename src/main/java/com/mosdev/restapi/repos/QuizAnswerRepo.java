package com.mosdev.restapi.repos;

import com.mosdev.restapi.domain.QuizAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizAnswerRepo extends JpaRepository<QuizAnswer, Long> {
}
