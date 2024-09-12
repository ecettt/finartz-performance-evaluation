package com.finartz.userregistration.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.finartz.userregistration.entity.UserTitle;
import com.finartz.userregistration.repository.UserTitleRepository;

@Component
public class UserTitleInitializer implements CommandLineRunner{
    @Autowired
    private UserTitleRepository userTitleRepository;

    @Override
    public void run(String... args) throws Exception {
        if (userTitleRepository.count() == 0) {
            userTitleRepository.save(UserTitle.builder().title("Product Manager").build());
            userTitleRepository.save(UserTitle.builder().title("Product Manager Intern").build());
            userTitleRepository.save(UserTitle.builder().title("Backend Developer").build());
            userTitleRepository.save(UserTitle.builder().title("Backend Developer Intern").build());
            userTitleRepository.save(UserTitle.builder().title("Frontend Developer").build());
            userTitleRepository.save(UserTitle.builder().title("Backend Developer Intern").build());
            userTitleRepository.save(UserTitle.builder().title("Test Engineer").build());
            userTitleRepository.save(UserTitle.builder().title("Test Engineer Intern").build());
            userTitleRepository.save(UserTitle.builder().title("DevOps Engineer").build());
            userTitleRepository.save(UserTitle.builder().title("Lead Product Manager").build());
            userTitleRepository.save(UserTitle.builder().title("Software Development Director").build());
            userTitleRepository.save(UserTitle.builder().title("CTBO").build());
            userTitleRepository.save(UserTitle.builder().title("Software Development Team Lead").build());
            userTitleRepository.save(UserTitle.builder().title("UI/UX Designer").build());
        }
    }
}
