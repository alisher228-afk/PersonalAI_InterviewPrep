package org.akusher.personalai_interviewprep.Entity.mapper;

import org.akusher.personalai_interviewprep.Entity.Dto.Question.QuestionResponce.QuestionCreateResponse;
import org.akusher.personalai_interviewprep.Entity.Dto.Question.QuestionResponce.QuestionListResponse;
import org.akusher.personalai_interviewprep.Entity.Question;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface QuestionMapper {
    QuestionCreateResponse toQuestionCreateResponse (Question question);

    QuestionListResponse toQuestionListResponse(Question question);

    List<QuestionListResponse> toQuestionListResponse(List<Question> questions);
}