package com.example.taleadventure.domain.chapter.dto;

import com.example.taleadventure.domain.chapter.entity.Chapter;
import com.example.taleadventure.domain.talebook.dto.TaleBookInfoDto;
import com.example.taleadventure.domain.talebook.entity.TaleBook;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ChapterInfoDto {
    private Long id;
    private String title;
    private String imageUrl;
    private TaleBook taleBook;

    public static ChapterInfoDto of(Chapter chapter){
        return ChapterInfoDto.builder()
                .id(chapter.getId())
                .title(chapter.getTitle())
                .imageUrl(chapter.getImageUrl())
                .taleBook(chapter.getTaleBook())
                .build();
    }
}
