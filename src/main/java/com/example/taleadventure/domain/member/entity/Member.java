package com.example.taleadventure.domain.member.entity;

import com.example.taleadventure.base.entity.AuditingTimeEntity;
import com.example.taleadventure.domain.member.enummerate.Gender;
import com.example.taleadventure.domain.member.enummerate.Status;
import com.example.taleadventure.domain.wordbook.entity.WordBook;
import lombok.*;

import javax.persistence.*;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Builder
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Member extends AuditingTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String nickName;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @Column(nullable = false)
    private Integer age;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @OneToOne
    @JoinColumn(name = "word_book_id")
    private WordBook wordBook;
}
