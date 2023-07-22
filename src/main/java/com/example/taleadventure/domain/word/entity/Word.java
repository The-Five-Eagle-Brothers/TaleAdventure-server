package com.example.taleadventure.domain.word.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "word_id", nullable = false)
    private Long id;
    
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String mean;

}
