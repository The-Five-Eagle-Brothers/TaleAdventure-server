package com.example.taleadventure.domain.block.repository;

import com.example.taleadventure.domain.block.entity.BlockEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlockRepository extends JpaRepository<BlockEntity, Long> {
}
