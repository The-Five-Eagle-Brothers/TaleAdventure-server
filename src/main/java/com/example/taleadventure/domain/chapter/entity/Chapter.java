package com.example.taleadventure.domain.chapter.entity;

import com.example.taleadventure.base.entity.AuditingTimeEntity;
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
public class Chapter extends AuditingTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chapter_id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String title;


    @Column(nullable = false, length = 500)
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "tale_book_id")
    private TaleBook taleBook;

    public static Chapter newInstance(String title, TaleBook taleBook, String imageUrl){
        return Chapter.builder()
                .title(title)
                .imageUrl(imageUrl)
                .taleBook(taleBook)
                .build();
    }
}
