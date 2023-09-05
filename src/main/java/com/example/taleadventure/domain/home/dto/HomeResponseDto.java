package com.example.taleadventure.domain.home.dto;

import com.example.taleadventure.domain.talebook.entity.TaleBook;
import com.example.taleadventure.domain.word.dto.WordInfoDto;
import com.example.taleadventure.domain.word.entity.Word;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HomeResponseDto {
    Integer day;
    List<TaleBook> taleBooks;

    public static HomeResponseDto of(Integer day, List<TaleBook> taleBooks){
        return HomeResponseDto.builder()
                .day(day)
                .taleBooks(taleBooks)
                .build();
    }
}
