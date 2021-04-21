package com.janaagraha.Service;

import com.janaagraha.Utils.JanagrahaaUtils;
import com.janaagraha.entity.SurveyEntity;
import com.janaagraha.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurveyService {

@Autowired
JanagrahaaUtils janagrahaaUtils;

@Autowired
SurveyRepository surveyRepository;


/*public List<Survey> getAllSurveys(Long latLong) {
    List<SurveyEntity> surveyList = surveyRepository.findAllByLatLong(latLong);
    return janagrahaaUtils.mapList(surveyList,Survey.class);
}*/

/*public List<Survey> getAllSurveys(String location) {
    List<SurveyEntity> surveyList = surveyRepository.findAllByLocation(location);
    return janagrahaaUtils.mapList(surveyList,Survey.class);
}*/


}