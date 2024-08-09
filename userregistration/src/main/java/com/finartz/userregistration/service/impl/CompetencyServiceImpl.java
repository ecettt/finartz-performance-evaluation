package com.finartz.userregistration.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finartz.userregistration.entity.Competency;
import com.finartz.userregistration.entity.Evaluation;
import com.finartz.userregistration.exception.ResourceNotFoundException;
import com.finartz.userregistration.repository.CompetencyRepository;
import com.finartz.userregistration.repository.EvaluationRepository;
import com.finartz.userregistration.request.CreateCompetencyRequest;
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

        Competency competency = Competency.builder()
        .name(competencyRequest.getName())
        .description(competencyRequest.getDescription())
        .evaluation(evaluation)
        .build();

        // evaluation.getCompetencies().add(competency);
        // evaluationRepository.save(evaluation);

        return competencyRepository.save(competency);
    }

    @Override
    public void deleteCompetency(Long id) {
        Competency competency = competencyRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Competency not found with id: " + id));

        competencyRepository.delete(competency);
    }



    @Override
    public List<Competency> getAllCompetencies() {
        return competencyRepository.findAll();
    }
}
