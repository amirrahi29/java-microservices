package com.quiz.demo.repositiories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.quiz.demo.entities.QuizEntity;

public interface QuizRepository extends JpaRepository<QuizEntity,Long> {
    
}
