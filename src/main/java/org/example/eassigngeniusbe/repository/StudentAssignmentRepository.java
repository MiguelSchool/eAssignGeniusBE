package org.example.eassigngeniusbe.repository;

import org.example.eassigngeniusbe.model.entity.student.StudentAssignmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentAssignmentRepository extends JpaRepository<StudentAssignmentEntity,Long> { }
