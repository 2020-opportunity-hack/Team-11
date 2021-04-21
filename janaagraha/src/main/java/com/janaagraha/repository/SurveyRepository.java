package com.janaagraha.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.janaagraha.entity.Survey;

@Repository
public interface SurveyRepository extends MongoRepository<Survey, String> {
	
	List<Survey> findByLocation(String location);

	List<Survey> findByLatitudeAndLongitude(String latitude, String longitude);
}
