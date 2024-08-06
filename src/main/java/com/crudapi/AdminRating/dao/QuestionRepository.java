package com.crudapi.AdminRating.dao;

import com.crudapi.AdminRating.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
}
