package org.akusher.personalai_interviewprep.Entity.mapper;

import org.akusher.personalai_interviewprep.Entity.Dto.Question.QuestionResponce.QuestionCreateResponse;
import org.akusher.personalai_interviewprep.Entity.Dto.Question.QuestionResponce.QuestionListResponse;
import org.akusher.personalai_interviewprep.Entity.Question;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
    @Mapping(target = "topicId", source = "topic.id")
    QuestionCreateResponse toQuestionCreateResponse (Question question);

    QuestionListResponse toQuestionListResponse(Question question);

    List<QuestionListResponse> toQuestionListResponse(List<Question> questions);
}