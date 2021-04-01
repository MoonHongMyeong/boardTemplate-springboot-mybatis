package me.moon.boardTemplate.dto.post;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostResponseDto {
    private String categoryName;
    private String userName;
    private Long id;
    private String title;
    private String content;
    private String image;
    private String modified_date;
}
