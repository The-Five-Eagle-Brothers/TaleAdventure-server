package com.example.taleadventure.domain.word.dto;

import com.example.taleadventure.domain.chapter.dto.ChapterInfoDto;
import com.example.taleadventure.domain.chapter.entity.Chapter;
import com.example.taleadventure.domain.word.entity.Word;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class WordInfoDto {
    private Long id;
    private String name;
    private String mean;
    private String sentence;
    private String example;
    private Boolean bookMark;
    private String imageUrl;
    private Chapter chapter;

    public static WordInfoDto of(Word word){
        return WordInfoDto.builder()
                .id(word.getId())
                .name(word.getName())
                .mean(word.getMean())
                .sentence(word.getSentence())
                .example(word.getExample())
                .bookMark(word.getBookMark())
                .imageUrl(word.getImageUrl())
                .chapter(word.getChapter())
                .build();
    }
}
