package com.quiz.demo.services;

import java.util.List;

import com.quiz.demo.entities.QuizEntity;

public interface QuizService {

    QuizEntity add(QuizEntity Quiz);

    List<QuizEntity> get();

    QuizEntity getOne(Long id);

}
