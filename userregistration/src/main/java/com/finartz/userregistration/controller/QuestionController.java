package com.finartz.userregistration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.finartz.userregistration.entity.Question;
import com.finartz.userregistration.request.CreateQuestionRequest;
import com.finartz.userregistration.service.QuestionService;

@RestController
@RequestMapping("/api")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @PostMapping("/competencies/questions")
    public ResponseEntity<Question> saveQuestion(@RequestBody CreateQuestionRequest questionRequest) {
        return ResponseEntity.ok(questionService.saveQuestion(questionRequest));
    }
}
