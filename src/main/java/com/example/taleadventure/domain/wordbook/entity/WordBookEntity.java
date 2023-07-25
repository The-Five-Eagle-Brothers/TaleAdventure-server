package com.example.taleadventure.domain.wordbook.entity;

import com.example.taleadventure.domain.user.entity.UserEntity;
import com.example.taleadventure.domain.word.entity.WordEntity;
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
public class WordBookEntity {
    @Id
    @GeneratedValue
    @Column(name = "word_book_id", nullable = false)
    private Long id;

    @OneToOne
    private UserEntity userEntity;

    @OneToMany
    @JoinColumn(name = "word_book_id")
    private List<WordEntity> wordEntities = new ArrayList<>();
}
