package com.example.taleadventure.domain.member.repository;

import com.example.taleadventure.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
