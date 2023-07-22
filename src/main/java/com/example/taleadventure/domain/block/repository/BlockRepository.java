package com.example.taleadventure.domain.block.repository;

import com.example.taleadventure.domain.block.entity.Block;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlockRepository extends JpaRepository<Block, Long> {
}
