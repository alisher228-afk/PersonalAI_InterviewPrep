package org.akusher.personalai_interviewprep.Entity.mapper;

import org.akusher.personalai_interviewprep.Entity.Dto.Answers.AnswersResponse.AnswerCreateResponse;
import org.akusher.personalai_interviewprep.Entity.Answer;
import org.akusher.personalai_interviewprep.Entity.Dto.Answers.AnswersResponse.AnswerListResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AnswerMapper {
    AnswerCreateResponse toAnswerCreateResponse (Answer answer);

    AnswerListResponse toAnswerListResponse(Answer answer);

    List<AnswerListResponse> toAnswerListResponse(List<Answer> answers);
}
