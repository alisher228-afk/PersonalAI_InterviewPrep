package org.akusher.personalai_interviewprep.Entity.Dto.Answers.AnswersResponse;

public record AnswerCreateResponse(
        Long Id,
        Long questionId,
        Double ai_score,
        String ai_feedback
) {
}
