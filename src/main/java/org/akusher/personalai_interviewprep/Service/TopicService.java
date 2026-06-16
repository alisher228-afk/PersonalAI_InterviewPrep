package org.akusher.personalai_interviewprep.Service;

import org.akusher.personalai_interviewprep.Entity.Dto.Responce.TopicCreateRequest;
import org.akusher.personalai_interviewprep.Entity.Dto.Responce.TopicCreateResponse;
import org.akusher.personalai_interviewprep.Entity.Dto.Responce.TopicListResponse;
import org.akusher.personalai_interviewprep.Entity.Topic;
import org.akusher.personalai_interviewprep.Entity.mapper.TopicMapper;
import org.akusher.personalai_interviewprep.Entity.repository.TopicRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
    public static final Logger log = LoggerFactory.getLogger(TopicService.class);

    private final TopicRepository topicRepository;
    private final TopicMapper topicMapper;

    public TopicService(TopicRepository topicRepository, TopicMapper topicMapper) {
        this.topicRepository = topicRepository;
        this.topicMapper = topicMapper;
    }

    public TopicCreateResponse createTopic(TopicCreateRequest request) {
        Topic topic = new Topic();
        topic.setName(request.name());
        topic.setDescription(request.description());
        topicRepository.save(topic);
        return topicMapper.toTopicCreateResponse(topic);
    }

    public Page<TopicListResponse> getTopics(int page, int size) {
        log.info("Getting Topic list of size {}", size);
        Pageable pageable = PageRequest.of(page, size);
        return topicRepository.findAll(pageable).map(topicMapper::toTopicListResponse);
    }

    public TopicListResponse getTopicById(Long id) {
        log.info("Getting Topic with id {}", id);
        return topicRepository.findById(id)
                .map(topicMapper::toTopicListResponse)
                .orElseThrow(() -> new RuntimeException("Topic not found with id: " + id));
    }

    public TopicListResponse updateTopic(TopicCreateRequest request) {
        log.info("Updating Topic with name {}", request.name());
        Topic topic = new Topic();
        topic.setName(request.name());
        topic.setDescription(request.description());
        topicRepository.save(topic);
        return topicMapper.toTopicListResponse(topic);
    }

    public TopicListResponse deleteTopicById(Long id) {
        log.info("Deleting Topic with id {}", id);
        var topic = topicRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Topic not found with id: " + id));
        topicRepository.delete(topic);
        return topicMapper.toTopicListResponse(topic);
    }
}
