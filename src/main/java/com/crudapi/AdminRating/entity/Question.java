package com.crudapi.AdminRating.entity;


import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "surveyId", nullable = false)
    private Integer surveyId;

    @Column(name = "text")
    private String text;

    @Column(name = "generationDate")
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date generationDate;

    @Column(name = "terminationDate")
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date terminationDate;

    public Question(){}

    public Question(Integer surveyId, String text, Date generationDate, Date terminationDate) {
        this.surveyId = surveyId;
        this.text = text;
        this.generationDate = generationDate;
        this.terminationDate = terminationDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(Integer surveyId) {
        this.surveyId = surveyId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getGenerationDate() {
        return generationDate;
    }

    public void setGenerationDate(Date generationDate) {
        this.generationDate = generationDate;
    }

    public Date getTerminationDate() {
        return terminationDate;
    }

    public void setTerminationDate(Date terminationDate) {
        this.terminationDate = terminationDate;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", surveyId=" + surveyId +
                ", text='" + text + '\'' +
                ", generationDate=" + generationDate +
                ", terminationDate=" + terminationDate +
                '}';
    }
}
