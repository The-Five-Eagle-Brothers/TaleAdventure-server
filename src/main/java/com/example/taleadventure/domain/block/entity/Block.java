package com.example.taleadventure.domain.block.entity;

import com.example.taleadventure.domain.day.entity.Day;
import com.example.taleadventure.domain.talebook.entity.TaleBook;
import lombok.*;

import javax.persistence.*;

@ToString
@Builder
@Entity
@Getter
@Table(name = "block")
@AllArgsConstructor
@NoArgsConstructor
public class Block {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "block_id", nullable = false)
    private Long id;

    @Column(nullable = false, length = 1)
    private String letter;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "day_id")
    private Day day;

}
