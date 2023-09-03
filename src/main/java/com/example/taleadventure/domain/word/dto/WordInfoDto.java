package com.example.taleadventure.domain.word.dto;

import com.example.taleadventure.domain.chapter.entity.Chapter;
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
}
