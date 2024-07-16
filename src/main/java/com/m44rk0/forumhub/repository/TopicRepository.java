package com.m44rk0.forumhub.repository;

import com.m44rk0.forumhub.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TopicRepository extends JpaRepository<Topic, Long> {

    Optional<Topic> findByTitleAndAuthorName(String title, String authorName);

}
