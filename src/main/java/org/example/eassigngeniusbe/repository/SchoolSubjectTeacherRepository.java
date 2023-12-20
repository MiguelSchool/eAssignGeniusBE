package org.example.eassigngeniusbe.repository;

import org.example.eassigngeniusbe.model.entity.teacher.SubjectTeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolSubjectTeacherRepository extends JpaRepository<SubjectTeacherEntity,Long> { }
