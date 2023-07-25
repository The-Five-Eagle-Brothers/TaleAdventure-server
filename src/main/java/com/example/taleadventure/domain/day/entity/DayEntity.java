package com.example.taleadventure.domain.day.entity;

import lombok.*;

import javax.persistence.*;

@ToString
@Builder
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DayEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "day_id", nullable = false)
    private Long id;
}
