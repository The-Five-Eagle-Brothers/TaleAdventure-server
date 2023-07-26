package com.example.taleadventure.domain.talebook.repository;

import com.example.taleadventure.domain.talebook.entity.TaleBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaleBookRepository extends JpaRepository<TaleBook, Long> {
}
