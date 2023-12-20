package org.example.eassigngeniusbe.repository;

import org.example.eassigngeniusbe.model.entity.SchoolClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolClassRepository extends JpaRepository<SchoolClassEntity,Long> { }
