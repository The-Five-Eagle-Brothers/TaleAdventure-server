package com.example.taleadventure.domain.library.repository;

import com.example.taleadventure.domain.library.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Library, Long> {
}
