package com.example.taleadventure.domain.chapter.repository;

import com.example.taleadventure.domain.chapter.entity.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChapterRepository extends JpaRepository<Chapter, Long> {
}
