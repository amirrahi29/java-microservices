package com.question.demo.services;

import java.util.List;

import com.question.demo.entities.QuestionEntity;

public interface QuestionService {
    
    QuestionEntity addQuestion(QuestionEntity questionEntity);

    List<QuestionEntity> get();

    QuestionEntity getOne(Long id);

    List<QuestionEntity> getQuestionsOfQuiz(Long quizId);

}
