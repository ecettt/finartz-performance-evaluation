package com.finartz.userregistration.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finartz.userregistration.entity.Evaluation;
import com.finartz.userregistration.repository.EvaluationRepository;
import com.finartz.userregistration.request.CreateEvaluationRequest;
import com.finartz.userregistration.service.EvaluationService;


@Service
public class EvaluationServiceImpl implements EvaluationService{
    @Autowired
    private EvaluationRepository evaluationRepository;

    @Override
    public Evaluation saveEvaluation(CreateEvaluationRequest evaluationRequest) {
        var evaluation = Evaluation.builder()
        .termName(evaluationRequest.getTermName())
        .internalEvaluation(evaluationRequest.getInternalEvaluation())
        .evaluationName(evaluationRequest.getEvaluationName())
        .startDate(evaluationRequest.getStartDate())
        .endDate(evaluationRequest.getEndDate())
        .email(evaluationRequest.getEmail())
        .phone(evaluationRequest.getPhone())
        .build();

        evaluationRepository.save(evaluation);
        return evaluation;
    }
    
}
