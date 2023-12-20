package org.example.eassigngeniusbe.repository;

import org.example.eassigngeniusbe.model.entity.ExcursionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExcursionRepository extends JpaRepository<ExcursionEntity, Long> { }
