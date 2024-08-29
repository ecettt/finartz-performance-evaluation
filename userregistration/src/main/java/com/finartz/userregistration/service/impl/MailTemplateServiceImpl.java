package com.finartz.userregistration.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finartz.userregistration.entity.MailTemplate;
import com.finartz.userregistration.repository.MailTemplateRepository;
import com.finartz.userregistration.request.CreateMailTemplateRequest;
import com.finartz.userregistration.service.MailTemplateService;

@Service
public class MailTemplateServiceImpl implements MailTemplateService{
    @Autowired
    private MailTemplateRepository mailTemplateRepository;

    @Override
    public MailTemplate createMailTemplate(CreateMailTemplateRequest mailTemplateRequest) {
        var template = MailTemplate.builder()
        .title(mailTemplateRequest.getTitle())
        .description(mailTemplateRequest.getDescription())
        .build();

        mailTemplateRepository.save(template);
        return template;
    }
}
