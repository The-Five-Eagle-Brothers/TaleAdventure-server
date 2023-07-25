package com.example.taleadventure.domain.block.entity;

import com.example.taleadventure.domain.day.entity.DayEntity;
import lombok.*;

import javax.persistence.*;

@ToString
@Builder
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BlockEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "block_id", nullable = false)
    private Long id;

    @Column(nullable = false, length = 1)
    private String letter;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "day_id")
    private DayEntity dayEntity;

}
