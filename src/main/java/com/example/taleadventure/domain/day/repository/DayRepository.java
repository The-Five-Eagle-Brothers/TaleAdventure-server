package com.example.taleadventure.domain.day.repository;

import com.example.taleadventure.domain.day.entity.DayEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DayRepository extends JpaRepository<DayEntity, Long> {
}
