package com.example.taleadventure.domain.word.repository;

import com.example.taleadventure.domain.word.entity.WordEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordRepository extends JpaRepository<WordEntity, Long> {
}
