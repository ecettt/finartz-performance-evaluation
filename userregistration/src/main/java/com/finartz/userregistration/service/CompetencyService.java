package com.finartz.userregistration.service;

import java.util.List;

import com.finartz.userregistration.entity.Competency;
import com.finartz.userregistration.request.CreateCompetencyRequest;

public interface CompetencyService {
    Competency saveCompetency(CreateCompetencyRequest competencyRequest);
    List<Competency> getAllCompetencies();
    void deleteCompetency(Long id);
}
