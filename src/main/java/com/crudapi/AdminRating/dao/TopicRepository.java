package com.crudapi.AdminRating.dao;

import com.crudapi.AdminRating.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Integer> {
}
