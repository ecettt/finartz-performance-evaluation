package com.finartz.userregistration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finartz.userregistration.entity.Evaluation;
import com.finartz.userregistration.request.CreateEvaluationRequest;
import com.finartz.userregistration.service.EvaluationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/evaluations")
public class EvaluationController {
    @Autowired
    private EvaluationService evaluationService;

    @PostMapping("/save")
    public ResponseEntity<Evaluation> saveEvaluation(@Valid @RequestBody CreateEvaluationRequest evaluationRequest) {
        return ResponseEntity.ok(evaluationService.saveEvaluation(evaluationRequest));
    }
}
