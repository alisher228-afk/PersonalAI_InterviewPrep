package org.akusher.personalai_interviewprep.Entity.Dto.Question.QuestionResponce;

import org.akusher.personalai_interviewprep.Entity.Difficult;

public record QuestionListResponse(
        Long id,
        String text,
        Difficult difficulty
) {
}
