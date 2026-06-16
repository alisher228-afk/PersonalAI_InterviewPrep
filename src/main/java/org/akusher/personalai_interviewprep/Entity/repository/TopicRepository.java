package org.akusher.personalai_interviewprep.Entity.repository;

import org.akusher.personalai_interviewprep.Entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
}
