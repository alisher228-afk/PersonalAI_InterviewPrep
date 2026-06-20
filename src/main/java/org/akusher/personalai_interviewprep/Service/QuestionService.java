package org.akusher.personalai_interviewprep.Service;

import jakarta.persistence.EntityNotFoundException;
import org.akusher.personalai_interviewprep.Entity.Dto.Question.QuestionRequest.QuestionCreateRequest;
import org.akusher.personalai_interviewprep.Entity.Dto.Question.QuestionResponce.QuestionCreateResponse;
import org.akusher.personalai_interviewprep.Entity.Dto.Question.QuestionResponce.QuestionListResponse;
import org.akusher.personalai_interviewprep.Entity.Question;
import org.akusher.personalai_interviewprep.Entity.Topic;
import org.akusher.personalai_interviewprep.Entity.mapper.QuestionMapper;
import org.akusher.personalai_interviewprep.Entity.repository.QuestionRepository;
import org.akusher.personalai_interviewprep.Entity.repository.TopicRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final QuestionMapper  questionMapper;
    private final TopicRepository topicRepository;

    public QuestionService(QuestionRepository questionRepository, QuestionMapper questionMapper, TopicRepository topicRepository) {
        this.questionRepository = questionRepository;
        this.questionMapper = questionMapper;
        this.topicRepository = topicRepository;
    }

    public QuestionCreateResponse createQuestion(Long topicId, QuestionCreateRequest request) {
        Topic topic = topicRepository.findById(topicId)
                .orElseThrow(() -> new EntityNotFoundException("Topic not found with id: " + topicId));

        Question question = new Question();
        question.setTopic(topic);
        question.setText(request.text());
        question.setDifficulty(request.difficulty());
        questionRepository.save(question);

        return questionMapper.toQuestionCreateResponse (question);
    }

    public List<QuestionListResponse> getQuestionsByTopicId(Long topicId) {
        Topic topic = topicRepository.findById(topicId)
                .orElseThrow(() -> new EntityNotFoundException("Topic not found with id: " + topicId));

        List<Question> questions = questionRepository.findByTopicId(topicId);

        return questionMapper.toQuestionListResponse(questions);
    }

    public QuestionListResponse getQuestionById(Long questionId) {
        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new EntityNotFoundException("Question not found with id: " + questionId));
        return questionMapper.toQuestionListResponse(question);
    }
}
