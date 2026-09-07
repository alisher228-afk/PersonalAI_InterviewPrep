package org.akusher.personalai_interviewprep.Entity.Dto.Answers.AnswersResponse;

public record AnswerListResponse(
        Long Id,
        Double ai_score,
        String ai_feedback,
        String answerText
) {
}
