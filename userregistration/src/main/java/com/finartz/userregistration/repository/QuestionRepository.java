package com.finartz.userregistration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finartz.userregistration.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Long>{
    
}
