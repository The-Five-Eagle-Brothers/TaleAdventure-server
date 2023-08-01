package com.example.taleadventure.domain.wordbook.repository;

import com.example.taleadventure.domain.wordbook.entity.WordBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordBookRepository extends JpaRepository<WordBook, Long> {
}
