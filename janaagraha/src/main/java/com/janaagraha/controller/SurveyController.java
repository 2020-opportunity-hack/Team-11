package com.janaagraha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.janaagraha.entity.Survey;
import com.janaagraha.repository.SurveyRepository;

@RestController
@RequestMapping("/v1")
public class SurveyController {

	@Autowired
	SurveyRepository surveyRepo;

	@GetMapping("/survey/{location}")
	public List<Survey> retriveSurveyByGeoLocation(@PathVariable String location) {
		return surveyRepo.findByLocation(location);
	}

	@GetMapping("/survey/{id}/byid")
	public Survey retriveSurveyById(@PathVariable String id) {
		return surveyRepo.findById(id).orElse(new Survey());
	}

	@GetMapping("/survey/LatitudeAndLongitude")
	public List<Survey> retriveSurveyByLatitudeAndLongitude(@RequestParam String latitude,
			@RequestParam String longitude) {
		return surveyRepo.findByLatitudeAndLongitude(latitude, longitude);
	}

	@GetMapping("/survey/remove")
	public void removeAllSurvey() {
		surveyRepo.deleteAll();
	}

	@GetMapping("/survey")
	public List<Survey> findAllSurvey() {
		return surveyRepo.findAll();
	}

	@PostMapping("/survey")
	public Survey insertSurvey(@RequestBody Survey survey) {
		return surveyRepo.save(survey);
	}

}
