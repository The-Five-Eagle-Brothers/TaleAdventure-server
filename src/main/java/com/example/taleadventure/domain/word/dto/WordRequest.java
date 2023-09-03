package com.example.taleadventure.domain.word.dto;

import com.example.taleadventure.domain.chapter.entity.Chapter;
import com.example.taleadventure.domain.talebook.entity.TaleBook;
import com.example.taleadventure.domain.word.entity.Word;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class WordRequest {
    private String name;
    private String mean;
    private String sentence;
    private String example;
    //bookmark는 저장할 때 false로 설정
    private Long chapterId;

    public Word toWordEntity(Chapter chapter, String url){
        return Word.newInstance(name, mean, sentence, example, chapter, url);
    }
}
