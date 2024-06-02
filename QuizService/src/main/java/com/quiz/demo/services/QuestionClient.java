package com.quiz.demo.services;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.quiz.demo.entities.QuestionEntity;

// @FeignClient(url = "http://localhost:8082", value = "Question-Client")
@FeignClient(name = "QUESTIONSERIVE")
public interface QuestionClient {

    @GetMapping("/question/getAllQuestionOfSpecificQuiz/{id}")
    List<QuestionEntity> getQuestionQuiz(@PathVariable Long id);
    
}
