package com.crudapi.AdminRating.service;

import com.crudapi.AdminRating.entity.Question;
import com.crudapi.AdminRating.entity.Survey;
import com.crudapi.AdminRating.entity.Topic;

import java.util.List;

public interface FormService {

    List<Topic> findAllTopic();

    Topic save(Topic theTopic);

    Topic findTopicById(int theId);

    void deleteTopicById(int theId);



    List<Survey> findAllSurvey();

    Survey save(Survey theSurvey);

    Survey findSurveyById(int theId);

    void deleteSurveyById(int theId);



    List<Question> findAllQuestion();

    Question save(Question theQuestion);

    Question findQuestionById(int theId);

    void deleteQuestionById(int theId);

}
