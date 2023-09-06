package com.example.taleadventure.domain.word.repository;

import com.example.taleadventure.domain.chapter.entity.Chapter;
import com.example.taleadventure.domain.word.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WordRepository extends JpaRepository<Word, Long> {

    @Query("select w from Word w where w.chapter.title = :chapterTitle")
    List<Word> findAllByChapterTitle(@Param("chapterTitle") String title);

    @Query("select w from Word w where w.chapter.taleBook.name = :taleBookName")
    List<Word> findAllByTaleBookName(@Param("taleBookName") String name);
}
