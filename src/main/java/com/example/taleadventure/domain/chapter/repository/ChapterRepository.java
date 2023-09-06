package com.example.taleadventure.domain.chapter.repository;

import com.example.taleadventure.domain.chapter.entity.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChapterRepository extends JpaRepository<Chapter, Long> {

    @Query("select c from Chapter c where c.taleBook.name = :taleBookName")
    List<Chapter> findAllByTaleBookName(@Param("taleBookName") String name);
}
