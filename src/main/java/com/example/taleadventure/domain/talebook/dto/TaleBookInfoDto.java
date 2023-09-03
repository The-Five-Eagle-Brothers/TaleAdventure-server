package com.example.taleadventure.domain.talebook.dto;

import com.example.taleadventure.domain.talebook.enummerate.Category;
import lombok.*;

@ToString
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaleBookInfoDto {
    private Long id;
    private String name;
    private Category category;
    private String imageUrl;
}
