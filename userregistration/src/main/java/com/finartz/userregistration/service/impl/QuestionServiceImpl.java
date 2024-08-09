package com.finartz.userregistration.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finartz.userregistration.entity.Competency;
import com.finartz.userregistration.entity.Question;
import com.finartz.userregistration.repository.CompetencyRepository;
import com.finartz.userregistration.repository.QuestionRepository;
import com.finartz.userregistration.request.CreateQuestionRequest;
import com.finartz.userregistration.service.QuestionService;


@Service
public class QuestionServiceImpl implements QuestionService{
    @Autowired
    CompetencyRepository competencyRepository;

    @Autowired
    QuestionRepository questionRepository;

    @Override
    public Question saveQuestion(CreateQuestionRequest questionRequest) {
        Competency competency = competencyRepository.findById(questionRequest.getCompetencyId()).orElseThrow(() -> new RuntimeException("Competency not found"));

        Question question = Question.builder()
        .content(questionRequest.getContent())
        .competency(competency)
        .build();

        return questionRepository.save(question);
    } 
}
