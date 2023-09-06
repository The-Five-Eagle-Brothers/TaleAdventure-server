package com.example.taleadventure.domain.home.dto;

import com.example.taleadventure.domain.talebook.entity.TaleBook;
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
    String nickName;
    List<TaleBook> taleBooks;

    public static HomeResponseDto of(Integer day, String nickName, List<TaleBook> taleBooks){
        return HomeResponseDto.builder()
                .day(day)
                .nickName(nickName)
                .taleBooks(taleBooks)
                .build();
    }
}
