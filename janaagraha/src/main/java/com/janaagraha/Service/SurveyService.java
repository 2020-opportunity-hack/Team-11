package com.janaagraha.Service;

import com.janaagraha.Utils.JanagrahaaUtils;
import com.janaagraha.dto.Survey;
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


public List<SurveyEntity> getAllSurveys(Long latLong) {
    List<Survey> surveyList = surveyRepository.findAll(latLong);
    return janagrahaaUtils.mapList(surveyList,SurveyEntity.class);
}

public List<SurveyEntity> getAllSurveys(String location) {
    List<Survey> surveyList = surveyRepository.findAll(location);
    return janagrahaaUtils.mapList(surveyList,SurveyEntity.class);
}


}