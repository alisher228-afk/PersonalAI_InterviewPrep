package org.akusher.personalai_interviewprep.Entity.repository;

import org.akusher.personalai_interviewprep.Entity.Dto.Question.QuestionResponce.QuestionListResponse;
import org.akusher.personalai_interviewprep.Entity.Question;
import org.akusher.personalai_interviewprep.Entity.Topic;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Long> {
    List<Question> findByTopicId(Long topicId);
}
