package org.akusher.personalai_interviewprep.Service;

import jakarta.persistence.EntityNotFoundException;
import org.akusher.personalai_interviewprep.Entity.Answer;
import org.akusher.personalai_interviewprep.Entity.Dto.Answers.AnswersRequest.AnswerCreateRequest;
import org.akusher.personalai_interviewprep.Entity.Dto.Answers.AnswersResponse.AnswerCreateResponse;
import org.akusher.personalai_interviewprep.Entity.Dto.Answers.AnswersResponse.AnswerListResponse;
import org.akusher.personalai_interviewprep.Entity.Question;
import org.akusher.personalai_interviewprep.Entity.mapper.AnswerMapper;
import org.akusher.personalai_interviewprep.Entity.repository.AnswerRepository;
import org.akusher.personalai_interviewprep.Entity.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {
    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;
    private final AnswerMapper answerMapper;

    public AnswerService(AnswerRepository answerRepository, QuestionRepository questionRepository, AnswerMapper answerMapper) {
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;
        this.answerMapper = answerMapper;
    }
    public AnswerCreateResponse createAnswer(Long questionId,AnswerCreateRequest request) {
        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new EntityNotFoundException("Question not found with id: " + questionId));

        Answer answer = new Answer();
        answer.setQuestion(question);
        answer.setAnswer_text(request.answerText());
        answerRepository.save(answer);
        return answerMapper.toAnswerCreateResponse(answer);
    }
    public List<AnswerListResponse> getAnswersByQuestionId(Long questionId) {
        questionRepository.findById(questionId)
                .orElseThrow(() -> new EntityNotFoundException("Question not found with id: " + questionId));

        List<Answer> answers = answerRepository.findByQuestionId(questionId);

        return answerMapper.toAnswerListResponse(answers);
    }
    public AnswerListResponse getAnswerById(Long answerId) {
        Answer answer = answerRepository.findById(answerId)
                .orElseThrow(() -> new EntityNotFoundException("Answer not found with id: " + answerId));

        return answerMapper.toAnswerListResponse(answer);
    }

    public AnswerListResponse deleteAnswerById(Long answerId) {
        Answer answer = answerRepository.findById(answerId)
                .orElseThrow(() -> new EntityNotFoundException("Answer not found with id: " + answerId));
        answerRepository.delete(answer);
        return answerMapper.toAnswerListResponse(answer);
    }
}