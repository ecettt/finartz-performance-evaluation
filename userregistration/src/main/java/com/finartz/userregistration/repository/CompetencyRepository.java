package com.finartz.userregistration.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.finartz.userregistration.entity.Competency;

@Repository
public interface CompetencyRepository extends JpaRepository<Competency, Long>{
    List<Competency> findByEvaluationId(Long evaluationId);
} 