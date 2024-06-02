package com.quiz.demo.services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.quiz.demo.entities.QuizEntity;
import com.quiz.demo.repositiories.QuizRepository;

@Service
public class QuizServiceImpl implements QuizService {

    private QuizRepository quizRepository;
    private QuestionClient questionClient;

    public QuizServiceImpl(QuizRepository quizRepository, QuestionClient questionClient) {
        this.quizRepository = quizRepository;
        this.questionClient = questionClient;
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

    @Override
    public List<QuizEntity> getAllQuizesAndQuestions() {
        List<QuizEntity> quizes = quizRepository.findAll();
        List<QuizEntity> newQuizList = quizes.stream().map(quiz -> {
            quiz.setQuestions(questionClient.getQuestionQuiz(quiz.getId()));
            return quiz;
        }).collect(Collectors.toList());
        return newQuizList;
    }

    @Override
    public QuizEntity getOneQuestion(Long id) {
        QuizEntity quizEntity = quizRepository.findById(id).orElseThrow(()->new RuntimeException("No questions"));
        quizEntity.setQuestions(questionClient.getQuestionQuiz(id));
        return quizEntity;
    }
}
