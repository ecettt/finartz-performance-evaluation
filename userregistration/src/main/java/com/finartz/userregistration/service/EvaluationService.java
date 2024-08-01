package com.finartz.userregistration.service;


import com.finartz.userregistration.entity.Evaluation;
import com.finartz.userregistration.request.CreateEvaluationRequest;

public interface EvaluationService {
    Evaluation saveEvaluation(CreateEvaluationRequest evaluationRequest);
}
