package com.crudapi.AdminRating.controller;


import com.crudapi.AdminRating.entity.Question;
import com.crudapi.AdminRating.entity.Survey;
import com.crudapi.AdminRating.entity.Topic;
import com.crudapi.AdminRating.service.FormService;
import jakarta.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Date;

@RestController
@RequestMapping("/form")
public class FormController {

    private FormService formService;

    @Autowired
    public FormController(FormService formService) {
        this.formService = formService;
    }

    @PostConstruct
    private void loadData() {

        // create init topics, questions, surveys
        Topic top1 = new Topic("Who killed Jessica");
        Topic top2 = new Topic("Ghost of Sparta, story of Kratos");
        Topic top3 = new Topic("Avengers");

        Survey sur1 = new Survey(1,3,1,"What is the movie about?","I have no idea about the movie");

        Date theDate = new Date();

        Question ques1 = new Question(1, "What is the movie about?", theDate, null );

        //sur1.setQuestionId(ques1.getId());



        // save the all init data to the database
        formService.save(top1);
        formService.save(top2);
        formService.save(top3);
        formService.save(sur1);
        formService.save(ques1);

    }

    @GetMapping("/topics")
    public List<Topic> findAllTopics(){
        return formService.findAllTopic();
    }

    @GetMapping("/surveys")
    public List<Survey> findAllSurveys(){
        return formService.findAllSurvey();
    }

    @GetMapping("/questions")
    public List<Question> findAllQuestions(){
        return formService.findAllQuestion();
    }

    @PostMapping("/topics")
    public Topic createTopic(@RequestBody Topic topic){
        topic.setId(0);
        Topic dbTopic = formService.save(topic);
        return dbTopic;
    }

    @PostMapping("/surveys")
    public Survey createSurvey(@RequestBody Survey survey){
        survey.setId(0);
        survey.setQuestionId(0);
        Date date = new Date();

        Survey dbPhaseOneSurvey = formService.save(survey);

        Question questionBase = new Question(dbPhaseOneSurvey.getId(), dbPhaseOneSurvey.getQuestionString(), date, null);
        Question questionFinal = formService.save(questionBase);
        dbPhaseOneSurvey.setQuestionId(questionFinal.getId());

        Survey dbFinalSurvey = formService.save(dbPhaseOneSurvey);

        return dbFinalSurvey;
    }

    @PutMapping("/surveys/{id}")
    public Survey updateSurvey(@PathVariable Integer id, @RequestBody Survey survey){ //@RequestBody String questionText){
        Survey theSurvey = formService.findSurveyById(id);
        if(theSurvey == null){
            throw new RuntimeException("Survey with given id not found ; id - "+theSurvey.getId());
        }

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        Question oldQuestion = formService.findQuestionById(theSurvey.getQuestionId());
        oldQuestion.setTerminationDate(date);
        formService.save(oldQuestion);
        //Question newQuestion = new Question(theSurvey.getId(),questionText ,date , null);
        Question newQuestion = new Question(theSurvey.getId(), survey.getQuestionString(),date , null);

        Question thisQuestion = formService.save(newQuestion);

        theSurvey.setQuestionId(thisQuestion.getId());
        theSurvey.setQuestionString(survey.getQuestionString());

        Survey thisSurvey = formService.save(theSurvey);

        return thisSurvey;



    }

}
