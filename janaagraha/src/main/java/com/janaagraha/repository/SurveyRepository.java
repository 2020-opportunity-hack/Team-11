package com.janaagraha.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.janaagraha.dto.Survey;

import java.util.List;

@Repository
public interface SurveyRepository extends MongoRepository<Survey, Long> {

public List<Survey> findAll(Long latLong);

public List<Survey> findAll(String location);

}
