package com.quiz.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.quiz.demo.entities.QuizEntity;
import com.quiz.demo.services.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    
    private QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping("/addQuiz")
    public QuizEntity create(@RequestBody QuizEntity quizEntity){
        return quizService.add(quizEntity);
    }

    @GetMapping("getAllQuiz")
    public List<QuizEntity> get(){
        return quizService.get();
    }

    @GetMapping("getAllQuiz/{id}")
    public QuizEntity getOne(@PathVariable Long id){
        return quizService.getOne(id);
    }

    @GetMapping("getAllQuizesAndQuestions")
    public List<QuizEntity> getAllQuizesAndQuestions(){
        return quizService.getAllQuizesAndQuestions();
    }

    @GetMapping("getOneQuestion/{id}")
    public QuizEntity getOneQuestion(@PathVariable Long id){
        return quizService.getOneQuestion(id);
    }

}
