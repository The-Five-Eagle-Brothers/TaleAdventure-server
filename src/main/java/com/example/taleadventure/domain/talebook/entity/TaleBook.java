package com.example.taleadventure.domain.talebook.entity;

import com.example.taleadventure.domain.talebook.enummerate.Category;
import lombok.*;

import javax.persistence.*;

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
}
