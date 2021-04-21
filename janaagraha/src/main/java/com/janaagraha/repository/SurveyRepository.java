package com.janaagraha.repository;
import com.janaagraha.entity.SurveyEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurveyRepository extends MongoRepository<SurveyEntity, Long> {

/*public List<SurveyEntity> findAllByLatLong(Long latLong);*/

//public List<SurveyEntity> findAllByLocation(String location);
}

