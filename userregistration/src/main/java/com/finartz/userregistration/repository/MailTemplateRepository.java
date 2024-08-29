package com.finartz.userregistration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finartz.userregistration.entity.MailTemplate;

@Repository
public interface MailTemplateRepository extends JpaRepository<MailTemplate, Long>{
    
}
