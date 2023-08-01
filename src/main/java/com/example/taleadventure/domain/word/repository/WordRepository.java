package com.example.taleadventure.domain.word.repository;

import com.example.taleadventure.domain.word.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordRepository extends JpaRepository<Word, Long> {
}
