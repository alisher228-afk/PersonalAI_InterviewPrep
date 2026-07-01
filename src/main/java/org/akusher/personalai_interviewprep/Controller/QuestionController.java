package org.akusher.personalai_interviewprep.Controller;

import jakarta.validation.Valid;
import org.akusher.personalai_interviewprep.Entity.Dto.Question.QuestionRequest.QuestionCreateRequest;
import org.akusher.personalai_interviewprep.Entity.Dto.Question.QuestionResponce.QuestionCreateResponse;
import org.akusher.personalai_interviewprep.Entity.Dto.Question.QuestionResponce.QuestionListResponse;
import org.akusher.personalai_interviewprep.Service.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuestionController {
    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/api/topics/{topicId}/questions")
    public QuestionCreateResponse createQuestion(
            @PathVariable Long topicId,
            @RequestBody @Valid QuestionCreateRequest request) {
        return questionService.createQuestion(topicId, request);
    }

    @GetMapping("/api/topics/{topicId}/questions")
    public List<QuestionListResponse> getQuestionsByTopicId(@PathVariable Long topicId) {
        return questionService.getQuestionsByTopicId(topicId);
    }

    @GetMapping("/api/questions/{questionId}")
    public QuestionListResponse getQuestionById(@PathVariable Long questionId) {
        return questionService.getQuestionById(questionId);
    }

    @PutMapping("/api/questions/{questionId}")
    public QuestionListResponse updateQuestion(
            @PathVariable Long questionId,
            @RequestBody @Valid QuestionCreateRequest request) {
        return questionService.updateQuestion(questionId, request);
    }

    @DeleteMapping("/api/questions/{questionId}")
    public QuestionListResponse deleteQuestionById(@PathVariable Long questionId) {
        return questionService.deleteQuestionById(questionId);
    }
}

