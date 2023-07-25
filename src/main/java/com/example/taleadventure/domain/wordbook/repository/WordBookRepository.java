package com.example.taleadventure.domain.wordbook.repository;

import com.example.taleadventure.domain.wordbook.entity.WordBookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordBookRepository extends JpaRepository<WordBookEntity, Long> {
}
