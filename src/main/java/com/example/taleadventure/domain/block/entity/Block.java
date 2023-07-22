package com.example.taleadventure.domain.block.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
public class Block {
    @Id
    @GeneratedValue
    @Column(name = "block_id", nullable = false)
    private Long id;

    @Column(nullable = false, length = 1)
    private String letter;
}
