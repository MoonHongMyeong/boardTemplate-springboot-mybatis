package me.moon.boardTemplate.dto.category;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CategorySaveRequestDto {
    private String name;
    @Builder
    public CategorySaveRequestDto(String name){
        this.name = name;
    }
}
