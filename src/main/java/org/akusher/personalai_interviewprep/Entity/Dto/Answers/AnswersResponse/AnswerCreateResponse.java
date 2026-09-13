package org.akusher.personalai_interviewprep.Entity.Dto.Answers.AnswersResponse;

public record AnswerCreateResponse(
        Long id,
        Long questionId,
        Double aiScore,
        String aiFeedback
) {}