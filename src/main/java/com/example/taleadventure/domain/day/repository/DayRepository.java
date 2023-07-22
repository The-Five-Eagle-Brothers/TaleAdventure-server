package com.example.taleadventure.domain.day.repository;

import com.example.taleadventure.domain.day.entity.Day;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DayRepository extends JpaRepository<Day, Long> {
}
