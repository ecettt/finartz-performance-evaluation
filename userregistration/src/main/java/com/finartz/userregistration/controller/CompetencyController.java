package com.finartz.userregistration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finartz.userregistration.entity.Competency;
import com.finartz.userregistration.request.CreateCompetencyRequest;
import com.finartz.userregistration.service.CompetencyService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/competencies")
public class CompetencyController {
    @Autowired
    CompetencyService competencyService;

    @PostMapping
    public ResponseEntity<Competency> saveCompetency(@RequestBody CreateCompetencyRequest competencyRequest) {
        return ResponseEntity.ok(competencyService.saveCompetency(competencyRequest));
    }

    @GetMapping
    public ResponseEntity<List<Competency>> getAllCompetencies() {
        return ResponseEntity.ok(competencyService.getAllCompetencies());
    }

    @DeleteMapping("/{competencyId}")
    public ResponseEntity<String> deleteCompetency(@PathVariable Long competencyId) {
        competencyService.deleteCompetency(competencyId);
        return ResponseEntity.ok("Competency deleted!");
    }
}
