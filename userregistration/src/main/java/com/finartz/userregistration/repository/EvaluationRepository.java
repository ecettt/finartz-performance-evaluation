package com.finartz.userregistration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finartz.userregistration.entity.Evaluation;

@Repository
public interface EvaluationRepository extends JpaRepository<Evaluation, Long>{

    
} 
