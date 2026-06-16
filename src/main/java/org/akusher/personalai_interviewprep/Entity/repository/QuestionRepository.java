package org.akusher.personalai_interviewprep.Entity.repository;

import org.akusher.personalai_interviewprep.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Long> {
}
