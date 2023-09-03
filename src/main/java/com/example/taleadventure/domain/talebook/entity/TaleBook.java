package com.example.taleadventure.domain.talebook.entity;

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

    private String imageUrl;

}
