package com.crudapi.AdminRating.dao;

import com.crudapi.AdminRating.entity.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyRepository extends JpaRepository<Survey, Integer> {
}
