package org.akusher.personalai_interviewprep.Entity.Dto.Answers.AnswersRequest;

import jakarta.validation.constraints.NotBlank;

public record AnswerCreateRequest(
        @NotBlank String answerText
) {}