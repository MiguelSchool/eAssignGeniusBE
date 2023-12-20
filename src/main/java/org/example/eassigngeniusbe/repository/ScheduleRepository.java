package org.example.eassigngeniusbe.repository;

import org.example.eassigngeniusbe.model.entity.ScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends JpaRepository<ScheduleEntity,Long> { }
