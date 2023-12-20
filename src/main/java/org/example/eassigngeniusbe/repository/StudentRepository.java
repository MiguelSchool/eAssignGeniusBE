package org.example.eassigngeniusbe.repository;

import org.example.eassigngeniusbe.model.entity.student.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Long> { }
