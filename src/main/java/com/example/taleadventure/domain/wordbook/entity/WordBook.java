package com.example.taleadventure.domain.wordbook.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
public class WordBook {
    @Id
    @GeneratedValue
    @Column(name = "word_book_id", nullable = false)
    private Long id;
    
}
