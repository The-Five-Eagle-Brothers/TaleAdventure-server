package com.example.taleadventure.domain.talebook.repository;

import com.example.taleadventure.domain.talebook.entity.TaleBookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaleBookRepository extends JpaRepository<TaleBookEntity, Long> {
}
