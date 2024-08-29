package com.finartz.userregistration.service;

import com.finartz.userregistration.entity.MailTemplate;
import com.finartz.userregistration.request.CreateMailTemplateRequest;

public interface MailTemplateService {
    MailTemplate createMailTemplate(CreateMailTemplateRequest mailTemplateRequest);
}