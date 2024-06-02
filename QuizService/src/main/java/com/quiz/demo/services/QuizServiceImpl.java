package com.quiz.demo.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.quiz.demo.entities.QuizEntity;
import com.quiz.demo.repositiories.QuizRepository;

@Service
public class QuizServiceImpl implements QuizService {

    private QuizRepository quizRepository;

    public QuizServiceImpl(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    @Override
    public QuizEntity add(QuizEntity quiz) {
       return quizRepository.save(quiz);
    }

    @Override
    public List<QuizEntity> get() {
        return quizRepository.findAll();
    }

    @Override
    public QuizEntity getOne(Long id) {
        return quizRepository.findById(id).orElseThrow(() -> new RuntimeException("No quiz found"));
    }
    


}
