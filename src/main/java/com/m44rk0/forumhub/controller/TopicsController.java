package com.m44rk0.forumhub.controller;

import com.m44rk0.forumhub.dto.topicDTO.TopicDetailsData;
import com.m44rk0.forumhub.dto.topicDTO.TopicRegistrationData;
import com.m44rk0.forumhub.dto.topicDTO.TopicUpdateData;
import com.m44rk0.forumhub.model.Topic;
import com.m44rk0.forumhub.repository.TopicRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("/topics")
public class TopicsController {

    @Autowired
    private TopicRepository topicRepository;

    @PostMapping
    public ResponseEntity makeNewTopic(@RequestBody @Valid TopicRegistrationData data, UriComponentsBuilder uriBuilder) {

        Optional<Topic> topicOptional = topicRepository.findByTitleAndAuthorName(data.title(), data.authorName());
        if(topicOptional.isPresent()){
            return new ResponseEntity<>("Topico já existe", HttpStatus.BAD_REQUEST);
        }
        var topic = new Topic(data);
        topicRepository.save(topic);
        var uri = uriBuilder.path("/topics/{id}").buildAndExpand(topic.getId()).toUri();

        return ResponseEntity.created(uri).body(new TopicDetailsData(topic));
    }

    @GetMapping
    public ResponseEntity<Page<TopicDetailsData>> listAllTopics (@PageableDefault(size = 10) Pageable paginacao) {
        var page =  topicRepository.findAll(paginacao).map(TopicDetailsData::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity <TopicDetailsData> seeDetailsOfTopic (@PathVariable Long id) {

        Optional<Topic> topicOptional = topicRepository.findById(id);

        if (topicOptional.isPresent()) {
            var topic = topicOptional.get();
            return ResponseEntity.ok(new TopicDetailsData (topic));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<String> updateTopic (@PathVariable Long id, @RequestBody @Valid TopicUpdateData updateData) {

        Optional<Topic> topicOptional = topicRepository.findById(id);

        if (topicOptional.isPresent()) {
            Topic topic = topicOptional.get();
            topic.updateTopic(updateData);
            topicRepository.save(topic);
            return ResponseEntity.ok("Tópico atualizado com sucesso!");
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTopic (@PathVariable Long id) {

        Optional<Topic> topicOptional = topicRepository.findById(id);
        if (topicOptional.isPresent()) {
            topicRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
