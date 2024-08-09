package com.finartz.userregistration.service;

import com.finartz.userregistration.entity.Question;
import com.finartz.userregistration.request.CreateQuestionRequest;

public interface QuestionService {
    Question saveQuestion(CreateQuestionRequest questionRequest); 
}
