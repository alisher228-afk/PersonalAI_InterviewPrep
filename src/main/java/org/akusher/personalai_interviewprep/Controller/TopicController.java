package org.akusher.personalai_interviewprep.Controller;

import jakarta.validation.Valid;
import org.akusher.personalai_interviewprep.Entity.Dto.Topic.TopicRequest.TopicCreateRequest;
import org.akusher.personalai_interviewprep.Entity.Dto.Topic.TopicResponce.TopicCreateResponse;
import org.akusher.personalai_interviewprep.Entity.Dto.Topic.TopicResponce.TopicListResponse;
import org.akusher.personalai_interviewprep.Service.TopicService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/topics")
public class TopicController {
    private final TopicService topicService;

    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @PostMapping("/create")
    public TopicCreateResponse createTopic(@RequestBody @Valid TopicCreateRequest request) {
        return topicService.createTopic(request);
    }

    @GetMapping
    public Page<TopicListResponse> getTopics(@RequestParam int page, @RequestParam int size) {
        return topicService.getTopics(page, size);
    }

    @GetMapping("/{id}")
    public TopicListResponse getTopicsById(@PathVariable Long id) {
        return topicService.getTopicById(id);
    }

    @PutMapping("/{id}")
    public TopicListResponse updateTopic(@PathVariable Long id, @RequestBody @Valid TopicCreateRequest request) {
        return topicService.updateTopic(id, request);
    }

    @DeleteMapping("/{id}")
    public TopicListResponse deleteTopicById(@PathVariable Long id) {
        return topicService.deleteTopicById(id);
    }

}
