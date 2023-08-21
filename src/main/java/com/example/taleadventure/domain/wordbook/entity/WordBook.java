package com.example.taleadventure.domain.wordbook.entity;

import com.example.taleadventure.domain.member.entity.Member;
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
public class WordBook {
    @Id
    @GeneratedValue
    @Column(name = "word_book_id", nullable = false)
    private Long id;

    /*@OneToOne
    private Member member;*/

    @OneToMany
    @JoinColumn(name = "word_book_id")
    private List<Word> words = new ArrayList<>();

}
