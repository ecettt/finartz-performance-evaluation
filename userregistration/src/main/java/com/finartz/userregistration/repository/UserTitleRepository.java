package com.finartz.userregistration.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finartz.userregistration.entity.UserTitle;



@Repository
public interface UserTitleRepository extends JpaRepository<UserTitle, Integer>{
    Optional<UserTitle> findById(Long id);
}
