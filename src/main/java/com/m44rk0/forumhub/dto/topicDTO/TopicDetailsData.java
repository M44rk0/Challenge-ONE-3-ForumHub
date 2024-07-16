package com.m44rk0.forumhub.dto.topicDTO;

import com.m44rk0.forumhub.model.Topic;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record TopicDetailsData(
        @NotNull
        Long id,
        @NotBlank
        String title,
        @NotBlank
        String message,
        @NotNull
        LocalDateTime dateOf,
        @NotBlank
        String authorName,
        @NotBlank
        String courseName
) {
    public TopicDetailsData(Topic topic) {
        this(topic.getId(), topic.getTitle(), topic.getMessage(), topic.getDateOf(), topic.getAuthorName(), topic.getCourseName());
    }
}
