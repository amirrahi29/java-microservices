package com.question.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.question.demo.entities.QuestionEntity;
import com.question.demo.repositories.QuestionRepository;

@Service
public class QuestionServiceImpl implements QuestionService {

    private QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public QuestionEntity addQuestion(QuestionEntity questionEntity) {
        return questionRepository.save(questionEntity);
    }

    @Override
    public List<QuestionEntity> get() {
       return questionRepository.findAll();
    }

    @Override
    public QuestionEntity getOne(Long id) {
        return questionRepository.findById(id).orElseThrow(()->new RuntimeException("No questions found"));
    }

    @Override
    public List<QuestionEntity> getQuestionsOfQuiz(Long quizId) {
        return questionRepository.findByQuizId(quizId);
    }
    
}
