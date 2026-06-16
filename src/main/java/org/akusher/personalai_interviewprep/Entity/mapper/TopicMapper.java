package org.akusher.personalai_interviewprep.Entity.mapper;

import org.akusher.personalai_interviewprep.Entity.Dto.Responce.TopicCreateResponse;
import org.akusher.personalai_interviewprep.Entity.Dto.Responce.TopicListResponse;
import org.akusher.personalai_interviewprep.Entity.Topic;
import org.mapstruct.Mapper;

@Mapper
public interface TopicMapper {
    TopicListResponse toTopicListResponse(Topic topic);

    TopicCreateResponse toTopicCreateResponse(Topic topic);
}
