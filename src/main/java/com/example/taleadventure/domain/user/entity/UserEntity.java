package com.example.taleadventure.domain.user.entity;

import com.example.taleadventure.base.entity.AuditingTimeEntity;
import com.example.taleadventure.domain.user.enummerate.Gender;
import com.example.taleadventure.domain.user.enummerate.Status;
import com.example.taleadventure.domain.wordbook.entity.WordBookEntity;
import lombok.*;

import javax.persistence.*;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Builder
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity extends AuditingTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
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

    @OneToOne(mappedBy = "userEntity")
    private WordBookEntity wordBookEntity;
}
