package me.moon.boardTemplate.dto.post;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostUpdateRequestDto {
    private Long id;
    private Long category_id;
    private String title;
    private String content;
    private String image;

}
