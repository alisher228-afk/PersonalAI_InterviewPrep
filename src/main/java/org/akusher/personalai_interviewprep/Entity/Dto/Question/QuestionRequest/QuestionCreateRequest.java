package org.akusher.personalai_interviewprep.Entity.Dto.Question.QuestionRequest;

import jakarta.validation.constraints.NotBlank;
import org.akusher.personalai_interviewprep.Entity.Difficult;

public record QuestionCreateRequest(
        @NotBlank
        String text,
        Difficult difficulty
) {}