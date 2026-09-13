package org.akusher.personalai_interviewprep.Controller;

import jakarta.validation.Valid;
import org.akusher.personalai_interviewprep.Entity.Dto.Answers.AnswersRequest.AnswerCreateRequest;
import org.akusher.personalai_interviewprep.Entity.Dto.Answers.AnswersResponse.AnswerCreateResponse;
import org.akusher.personalai_interviewprep.Entity.Dto.Answers.AnswersResponse.AnswerListResponse;
import org.akusher.personalai_interviewprep.Service.AnswerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AnswerController {

    private final AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @PostMapping("/questions/{questionId}/answers")
    @ResponseStatus(HttpStatus.CREATED)
    public AnswerCreateResponse createAnswer(
            @PathVariable Long questionId,
            @Valid @RequestBody AnswerCreateRequest request
    ) {
        return answerService.createAnswer(questionId, request);
    }

    @GetMapping("/questions/{questionId}/answers")
    public List<AnswerListResponse> getAnswersByQuestionId(@PathVariable Long questionId) {
        return answerService.getAnswersByQuestionId(questionId);
    }

    @GetMapping("/answers/{answerId}")
    public AnswerListResponse getAnswerById(@PathVariable Long answerId) {
        return answerService.getAnswerById(answerId);
    }

    @DeleteMapping("/answers/{answerId}")
    public AnswerListResponse deleteAnswerById(@PathVariable Long answerId) {
        return answerService.deleteAnswerById(answerId);
    }
}