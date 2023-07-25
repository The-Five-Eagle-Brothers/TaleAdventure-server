package com.example.taleadventure.domain.word.entity;

import com.example.taleadventure.base.entity.AuditingTimeEntity;
import com.example.taleadventure.domain.talebook.entity.TaleBook;
import lombok.*;

import javax.persistence.*;

@ToString
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tale_book_id")
    private TaleBook taleBook;

}
