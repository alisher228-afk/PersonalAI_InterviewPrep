package org.akusher.personalai_interviewprep.Entity.Dto.Question.QuestionResponce;

import org.akusher.personalai_interviewprep.Entity.Difficult;

public record QuestionCreateResponse(
        Long id,
        Long topicId,
        String text,
        Difficult difficulty
) {}
