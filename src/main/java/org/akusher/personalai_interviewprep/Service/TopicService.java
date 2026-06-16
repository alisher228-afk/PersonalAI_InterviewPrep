package org.akusher.personalai_interviewprep.Service;

import org.akusher.personalai_interviewprep.Entity.Dto.Responce.TopicCreateRequest;
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

    public TopicCreateRequest createTopic(String name, String description) {
        Topic topic = new Topic();
        topic.setName(name);
        topic.setDescription(description);
        topicRepository.save(topic);
        return topicMapper.toTopicCreateRequest(topic);
    }

    public Page<TopicListResponse> getTopics(int page, int size) {
        log.info("Getting Topic list of size {}", size);
        Pageable pageable = PageRequest.of(page, size);
        return topicRepository.findAll(pageable).map(topicMapper::toTopicListResponse);
    }
}
