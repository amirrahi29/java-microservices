package com.question.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.question.demo.entities.QuestionEntity;

public interface QuestionRepository extends JpaRepository<QuestionEntity,Long> {
    
    List<QuestionEntity> findByQuizId(Long quizId) ;

}
