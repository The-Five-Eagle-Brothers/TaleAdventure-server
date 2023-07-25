package com.example.taleadventure.domain.date.repository;

import com.example.taleadventure.domain.date.entity.Date;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DateRepository extends JpaRepository<Date, Long> {
}
