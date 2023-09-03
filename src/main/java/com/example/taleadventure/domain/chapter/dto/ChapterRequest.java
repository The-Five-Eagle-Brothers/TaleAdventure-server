package com.example.taleadventure.domain.chapter.dto;

import com.example.taleadventure.domain.chapter.entity.Chapter;
import com.example.taleadventure.domain.talebook.entity.TaleBook;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ChapterRequest {
    private String title;
    private Long taleBookId;

    public Chapter toChapterEntity(TaleBook taleBook, String url){
        return Chapter.newInstance(title, taleBook, url);
    }

}
