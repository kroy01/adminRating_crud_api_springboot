package com.crudapi.AdminRating.service;

import com.crudapi.AdminRating.dao.QuestionRepository;
import com.crudapi.AdminRating.dao.SurveyRepository;
import com.crudapi.AdminRating.dao.TopicRepository;
import com.crudapi.AdminRating.entity.Question;
import com.crudapi.AdminRating.entity.Survey;
import com.crudapi.AdminRating.entity.Topic;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//@Data
//@AllArgsConstructor
@Service
public class FormServiceImpl implements FormService{

    private QuestionRepository questionRepository;
    private TopicRepository topicRepository;
    private SurveyRepository surveyRepository;

    public FormServiceImpl(QuestionRepository questionRepository, TopicRepository topicRepository, SurveyRepository surveyRepository) {
        this.questionRepository = questionRepository;
        this.topicRepository = topicRepository;
        this.surveyRepository = surveyRepository;
    }

    @Override
    public List<Topic> findAllTopic() {
        return topicRepository.findAll();
    }

    @Override
    //@Transactional
    public Topic save(Topic theTopic) {
        return topicRepository.save(theTopic);
    }

    @Override
    public Topic findTopicById(int theId) {
        Optional<Topic> result = topicRepository.findById(theId);
        Topic theTopic = null;
        if(result.isPresent()){
            theTopic = result.get();
        }else{
            throw new RuntimeException("Unable to get id - "+theId);
        }


        return theTopic;
    }

    @Override
    //@Transactional
    public void deleteTopicById(int theId) {
        topicRepository.deleteById(theId);
    }

    @Override
    public List<Survey> findAllSurvey() {
        return surveyRepository.findAll();
    }

    @Override
    public Survey save(Survey theSurvey) {
        return surveyRepository.save(theSurvey);
    }

    @Override
    public Survey findSurveyById(int theId) {
        Optional<Survey> result = surveyRepository.findById(theId);
        Survey theSurvey = null;
        if(result.isPresent()){
            theSurvey = result.get();
        }else{
            throw new RuntimeException("Unable to get id - "+theId);
        }


        return theSurvey;
    }

    @Override
    public void deleteSurveyById(int theId) {
        surveyRepository.deleteById(theId);
    }

    @Override
    public List<Question> findAllQuestion() {
        return questionRepository.findAll();
    }

    @Override
    public Question save(Question theQuestion) {
        return questionRepository.save(theQuestion);
    }

    @Override
    public Question findQuestionById(int theId) {
        Optional<Question> result = questionRepository.findById(theId);
        Question theQuestion = null;
        if(result.isPresent()){
            theQuestion = result.get();
        }else{
            throw new RuntimeException("Unable to get id - "+theId);
        }


        return theQuestion;
    }

    @Override
    public void deleteQuestionById(int theId) {
        questionRepository.deleteById(theId);
    }
}
