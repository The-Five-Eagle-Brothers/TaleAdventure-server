package com.example.taleadventure.domain.chapter.service;

import com.example.taleadventure.base.error.ErrorResponseResult;
import com.example.taleadventure.base.error.exception.NotFoundException;
import com.example.taleadventure.domain.chapter.entity.Chapter;
import com.example.taleadventure.domain.chapter.repository.ChapterRepository;

import java.util.List;

public class ChapterServiceUtils {

    public static List<Chapter> findAllByName(ChapterRepository chapterRepository, String name){
        List<Chapter> chapters = chapterRepository.findAllByTaleBookName(name);
        if(chapters == null){
            throw new NotFoundException(String.format("챕터가 존재하지 않습니다."), ErrorResponseResult.NOT_FOUND_CHAPTER_EXCEPTION);
        }
        return chapters;
    }
}
