package org.example.eassigngeniusbe.repository;

import org.example.eassigngeniusbe.model.entity.student.StudentQuestionAnswerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentQuestionAnswerEntityRepository extends JpaRepository<StudentQuestionAnswerEntity, Long> { }
