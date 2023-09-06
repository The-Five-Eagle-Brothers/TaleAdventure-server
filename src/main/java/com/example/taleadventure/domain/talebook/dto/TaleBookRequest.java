package com.example.taleadventure.domain.talebook.dto;

import com.example.taleadventure.domain.talebook.entity.TaleBook;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TaleBookRequest {
    private String name;
    private String category;

    public TaleBook toTaleBookEntity(String libraryImageUrl, String chapterImageUrl, String wordBookImageUrl){
        return TaleBook.newInstance(this.name, this.category, libraryImageUrl, chapterImageUrl, wordBookImageUrl);
    }
}
