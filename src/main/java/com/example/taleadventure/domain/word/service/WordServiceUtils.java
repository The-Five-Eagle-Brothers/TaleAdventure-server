package com.example.taleadventure.domain.word.service;

import com.example.taleadventure.base.error.ErrorResponseResult;
import com.example.taleadventure.base.error.exception.NotFoundException;
import com.example.taleadventure.domain.chapter.entity.Chapter;
import com.example.taleadventure.domain.word.entity.Word;
import com.example.taleadventure.domain.word.repository.WordRepository;

import java.util.List;

public class WordServiceUtils {

    public static Word findById(WordRepository wordRepository, Long Id){
        Word word = wordRepository.findById(Id).get();
        if(word == null){
            throw new NotFoundException(String.format("단어가 존재하지 않습니다."), ErrorResponseResult.NOT_FOUND_WORD_EXCEPTION);
        }
        return word;
    }

    public static List<Word> findAllByTitle(WordRepository wordRepository, String title){
        List<Word> words = wordRepository.findAllByChapterTitle(title);
        if(words == null){
            throw new NotFoundException(String.format("단어가 존재하지 않습니다."), ErrorResponseResult.NOT_FOUND_WORD_EXCEPTION);
        }
        return words;
    }
}
