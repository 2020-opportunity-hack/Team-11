package com.janaagraha.controller;
import java.util.List;
import java.util.Optional;

import com.janaagraha.Service.SurveyService;
import com.janaagraha.dto.Survey;
import com.janaagraha.entity.SurveyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.janaagraha.exception.SurveyNotFoundException;
import com.janaagraha.repository.SurveyRepository;


@RestController
@RequestMapping("/v1")
public class SurveyController {
@Autowired
SurveyRepository surveyRepo;
@Autowired
SurveyService surveyService;

/*
@GetMapping("/survey/geolocation")
public List<Survey> findAllByGeoLocation(@PathVariable Long latLong) {
    return surveyService.getAllSurveys(latLong);
}
*/

/*@GetMapping("/survey/location")
public List<Survey> findAllByLocation(@PathVariable String location) {
    return surveyService.getAllSurveys(location);
}*/

/*
@GetMapping("/survey/{id}")
public Survey findOne(@PathVariable Long id) throws SurveyNotFoundException {
    Optional<SurveyEntity> survey = surveyRepo.findById(id);
    if (survey.isPresent()) {
    return null;
    //TODO to do model mapping
       // return survey.get();
    } else {
        throw new SurveyNotFoundException("Survey with ID -" + id + " is not found");
    }
}*/

@PostMapping("/survey")
public SurveyEntity insertSurvey(@RequestBody SurveyEntity survey) {
    System.out.println("Inserting survey");

    return surveyRepo.save(survey);
}

}
