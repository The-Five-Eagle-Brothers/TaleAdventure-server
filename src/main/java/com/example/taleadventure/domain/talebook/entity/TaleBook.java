package com.example.taleadventure.domain.talebook.entity;

import com.example.taleadventure.domain.member.enummerate.Gender;
import com.example.taleadventure.domain.talebook.enummerate.Category;
import com.example.taleadventure.domain.word.entity.Word;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@ToString
@Builder
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TaleBook {
    @Id
    @GeneratedValue
    @Column(name = "tale_book_id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;

    @Column(length = 500)
    private String libraryImageUrl;

    @Column(length = 500)
    private String chapterImageUrl;

    @Column(length = 500)
    private String wordBookImageUrl;

    public static Category categoryStringToEnum(String str){
        if(str.equals("korea")){
            return Category.KOREA;
        }else{
            return Category.FOREIGN;
        }
    }

    public static TaleBook newInstance(String name, String category, String libraryImageUrl, String chapterImageUrl, String wordBookImageUrl){
        return TaleBook.builder()
                .name(name)
                .category(TaleBook.categoryStringToEnum(category))
                .libraryImageUrl(libraryImageUrl)
                .chapterImageUrl(chapterImageUrl)
                .wordBookImageUrl(wordBookImageUrl)
                .build();
    }
}
