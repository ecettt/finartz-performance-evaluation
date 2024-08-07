package com.finartz.userregistration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.finartz.userregistration.entity.Competency;
import com.finartz.userregistration.request.CreateCompetencyRequest;
import com.finartz.userregistration.request.CreateQuestionRequest;
import com.finartz.userregistration.service.CompetencyService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/competencies")
public class CompetencyController {
    @Autowired
    CompetencyService competencyService;
    
    @PostMapping("/saveCompetency")
    public ResponseEntity<Competency> saveCompetency(@RequestBody CreateCompetencyRequest competencyRequest) {
        return ResponseEntity.ok(competencyService.saveCompetency(competencyRequest));
    }

    @PostMapping("/saveQuestion")
    public ResponseEntity<Competency> saveQuestion(@RequestBody CreateQuestionRequest questionRequest, @RequestParam Long id) {
        return ResponseEntity.ok(competencyService.saveQuestion(questionRequest, id));
    }


}
