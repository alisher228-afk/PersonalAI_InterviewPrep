package org.akusher.personalai_interviewprep.Entity.Dto.Answers.AnswersResponse;

import java.time.LocalDateTime;

public record AnswerListResponse(
        Long id,
        Long questionId,
        String answerText,
        Double aiScore,
        String aiFeedback,
        LocalDateTime createdAt
) {}