package com.example.taleadventure.domain.word.entity;

import com.example.taleadventure.base.entity.AuditingTimeEntity;
import com.example.taleadventure.domain.chapter.entity.Chapter;
import com.example.taleadventure.domain.talebook.entity.TaleBook;
import lombok.*;

import javax.persistence.*;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Builder
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Word extends AuditingTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "word_id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String mean;

    @Column(nullable = false)
    private String sentence;

    @Column(nullable = false)
    private String example;

    @Column(nullable = false)
    private Boolean bookMark;

    @Column(nullable = false)
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "chapter_id")
    private Chapter chapter;

    public void updateBookMark(Boolean bookMark){
        this.bookMark = bookMark;
    }

    public static Word newInstance(String name, String mean, String sentence, String example, Chapter chapter, String imageUrl){
        return Word.builder()
                .name(name)
                .mean(mean)
                .sentence(sentence)
                .example(example)
                .bookMark(false)
                .chapter(chapter)
                .imageUrl(imageUrl)
                .build();
    }

}
