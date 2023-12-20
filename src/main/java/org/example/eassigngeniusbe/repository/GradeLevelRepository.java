package org.example.eassigngeniusbe.repository;

import org.example.eassigngeniusbe.model.entity.GradeLevelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeLevelRepository extends JpaRepository<GradeLevelEntity,Long> {  }
