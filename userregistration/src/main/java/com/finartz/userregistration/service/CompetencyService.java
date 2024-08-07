package com.finartz.userregistration.service;

import com.finartz.userregistration.entity.Competency;
import com.finartz.userregistration.request.CreateCompetencyRequest;
import com.finartz.userregistration.request.CreateQuestionRequest;

public interface CompetencyService {
    Competency saveCompetency(CreateCompetencyRequest competencyRequest);
    Competency saveQuestion(CreateQuestionRequest questionRequest, Long id);
}
