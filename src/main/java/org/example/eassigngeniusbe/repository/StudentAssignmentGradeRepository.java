package org.example.eassigngeniusbe.repository;

import org.example.eassigngeniusbe.model.entity.student.StudentAssignmentGradeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentAssignmentGradeRepository extends JpaRepository<StudentAssignmentGradeEntity,Long> { }
