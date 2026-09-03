package org.akusher.personalai_interviewprep.Entity.mapper;

import org.akusher.personalai_interviewprep.Entity.Dto.Topic.TopicResponce.TopicCreateResponse;
import org.akusher.personalai_interviewprep.Entity.Dto.Topic.TopicResponce.TopicListResponse;
import org.akusher.personalai_interviewprep.Entity.Topic;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TopicMapper {
    TopicListResponse toTopicListResponse(Topic topic);

    TopicCreateResponse toTopicCreateResponse(Topic topic);
}
