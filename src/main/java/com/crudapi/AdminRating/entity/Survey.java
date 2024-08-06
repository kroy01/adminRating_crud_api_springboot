package com.crudapi.AdminRating.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "survey")
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "topicId", nullable = false)
    private Integer topicId;

    @Column(name = "rating")
    private int rating;

    @Column(name = "questionId", nullable = false)
    private Integer questionId;

    @Column(name = "questionString")
    private String questionString;

    @Column(name = "response")
    private String response;

    public Survey(){}

    public Survey(Integer topicId, int rating, Integer questionId, String questionString, String response) {
        this.topicId = topicId;
        this.rating = rating;
        this.questionId = questionId;
        this.questionString = questionString;
        this.response = response;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getQuestionString() {
        return questionString;
    }

    public void setQuestionString(String questionString) {
        this.questionString = questionString;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "Survey{" +
                "id=" + id +
                ", topicId=" + topicId +
                ", rating=" + rating +
                ", questionId=" + questionId +
                ", questionString='" + questionString + '\'' +
                ", response='" + response + '\'' +
                '}';
    }
}
