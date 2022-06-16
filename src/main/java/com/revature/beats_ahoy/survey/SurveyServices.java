package com.revature.beats_ahoy.survey;


import com.revature.beats_ahoy.playlist.Playlist;
import com.revature.beats_ahoy.util.interfaces.Serviceable;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SurveyServices implements Serviceable<Survey> {


    private final SurveyDao surveyDao;

    @Autowired
    public SurveyServices(SurveyDao surveyDao){
        this. surveyDao = surveyDao;
    }

    @Override
    public Survey create(Survey newSurvey) {
        return surveyDao.save(newSurvey);

    }

    @Override
    public List<Survey> readAll() {

        return (List<Survey>) surveyDao.findAll();

    }

    @Override
    public Survey readById(String id) {

        return surveyDao.findById(Integer.valueOf(id)).get();
    }

    @Override
    public Survey update(Survey updatedSurvey) {
        return surveyDao.save(updatedSurvey);

    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public boolean validateInput(Survey object) {
        return false;
    }

}

