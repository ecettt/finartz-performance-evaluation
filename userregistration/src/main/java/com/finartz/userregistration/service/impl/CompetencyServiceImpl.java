package com.finartz.userregistration.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finartz.userregistration.entity.Competency;
import com.finartz.userregistration.entity.Evaluation;
import com.finartz.userregistration.entity.Question;
import com.finartz.userregistration.repository.CompetencyRepository;
import com.finartz.userregistration.repository.EvaluationRepository;
import com.finartz.userregistration.request.CreateCompetencyRequest;
import com.finartz.userregistration.request.CreateQuestionRequest;
import com.finartz.userregistration.service.CompetencyService;

@Service
public class CompetencyServiceImpl implements CompetencyService{

    @Autowired 
    CompetencyRepository competencyRepository;

    @Autowired
    EvaluationRepository evaluationRepository;

    @Override
    public Competency saveCompetency(CreateCompetencyRequest competencyRequest) {
        Evaluation evaluation = evaluationRepository.findById(competencyRequest.getEvaluationId()).orElseThrow(() -> new RuntimeException("Evaluation not found"));

        Competency competencyIn = Competency.builder()
        .name(competencyRequest.getName())
        .description(competencyRequest.getDescription())
        .evaluation(evaluation)
        .build();

        List<Question> questions = new ArrayList<>();
        for(CreateQuestionRequest questionRequest : competencyRequest.getQuestionList()) {
            Question question = Question.builder()
            .content(questionRequest.getContent())
            .competency(competencyIn)
            .build();
            questions.add(question);
        }

        competencyIn.setQuestionList(questions);

        return competencyRepository.save(competencyIn);
    }

    @Override
    public Competency saveQuestion(CreateQuestionRequest questionRequest, Long id) {
        Competency tempCompetency = competencyRepository.findById(id).orElseThrow(() -> new RuntimeException("Competency not found"));
        
        Question question = Question.builder()
        .content(questionRequest.getContent())
        .competency(tempCompetency)
        .build();

        tempCompetency.getQuestionList().add(question);
        return competencyRepository.save(tempCompetency);
    }
}
