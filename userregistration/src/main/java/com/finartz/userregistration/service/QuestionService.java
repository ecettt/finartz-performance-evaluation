package com.finartz.userregistration.service;

import java.util.List;

import com.finartz.userregistration.entity.Question;
import com.finartz.userregistration.request.CreateQuestionRequest;

public interface QuestionService {
    Question saveQuestion(CreateQuestionRequest questionRequest);
    List<Question> getQuestionsByCompetencyId(Long id);
    void deleteQuestion(Long id);
}
