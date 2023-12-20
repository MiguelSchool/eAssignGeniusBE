package org.example.eassigngeniusbe.repository;

import org.example.eassigngeniusbe.model.entity.SubjectSchoolClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolSubjectSchoolClassRepository extends JpaRepository<SubjectSchoolClassEntity,Long> { }
