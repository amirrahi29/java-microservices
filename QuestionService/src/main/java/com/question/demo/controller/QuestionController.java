package com.question.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.question.demo.entities.QuestionEntity;
import com.question.demo.services.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {
    
    private QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/addQuestion")
    public QuestionEntity addQuestion(@RequestBody QuestionEntity questionEntity){
        return questionService.addQuestion(questionEntity);
    }

    @GetMapping("/getAllQuestion")
    public List<QuestionEntity> getAllQuestion(){
        return questionService.get();
    }

    @GetMapping("/getAllQuestion/{id}")
    public QuestionEntity getAllQuestion(@PathVariable Long id){
        return questionService.getOne(id);
    }

    @GetMapping("/getAllQuestionOfSpecificQuiz/{id}")
    public List<QuestionEntity> getAllQuestionBySpecificQuiz(@PathVariable Long id){
        return questionService.getQuestionsOfQuiz(id);
    }

}
