package org.akusher.personalai_interviewprep.Entity.repository;

import org.akusher.personalai_interviewprep.Entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer,Long> {
}
