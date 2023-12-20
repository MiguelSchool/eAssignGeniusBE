package org.example.eassigngeniusbe.repository;

import org.example.eassigngeniusbe.model.entity.teacher.AssignmentSheetFeedbackEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignmentSheetFeedbackEntityRepository extends JpaRepository<AssignmentSheetFeedbackEntity, Long> {
}
