package com.m44rk0.forumhub.dto.topicDTO;

import jakarta.validation.constraints.NotBlank;


public record TopicRegistrationData(
        @NotBlank
        String title,
        @NotBlank
        String message,
        @NotBlank
        String authorName,
        @NotBlank
        String courseName
) {
}
