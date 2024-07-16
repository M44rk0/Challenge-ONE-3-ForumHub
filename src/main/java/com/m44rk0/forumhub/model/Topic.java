package com.m44rk0.forumhub.model;

import com.m44rk0.forumhub.dto.topicDTO.TopicRegistrationData;
import com.m44rk0.forumhub.dto.topicDTO.TopicUpdateData;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "Topic")
@Table(name = "topics")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Topic {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String message;
    private LocalDateTime dateOf;
    private String authorName;
    private String courseName;

    public Topic(TopicRegistrationData data) {
        this.title = data.title();
        this.message = data.message();
        this.dateOf = LocalDateTime.now();
        this.authorName = data.authorName();
        this.courseName = data.courseName();
    }

    public void updateTopic(TopicUpdateData topicData) {
        this.message = topicData.message();
    }
}
