package me.moon.boardTemplate.dto.category;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdateRequestCategoryDto {
    private Long id;
    private String name;
}
