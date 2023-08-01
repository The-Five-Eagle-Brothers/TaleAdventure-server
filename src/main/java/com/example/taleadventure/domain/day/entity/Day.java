package com.example.taleadventure.domain.day.entity;

import com.example.taleadventure.domain.block.entity.Block;
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
public class Day {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "day_id", nullable = false)
    private Long id;

    @OneToMany
    @JoinColumn(name = "day_id")
    private List<Block> blocks = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "day_id")
    private List<Word> words = new ArrayList<>();

    
}
