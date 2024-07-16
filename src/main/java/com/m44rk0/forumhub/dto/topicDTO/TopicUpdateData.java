package com.m44rk0.forumhub.dto.topicDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TopicUpdateData(
        @NotNull
        Long id,
        @NotBlank
        String message
) {
}
