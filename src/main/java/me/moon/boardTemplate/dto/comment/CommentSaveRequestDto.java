package me.moon.boardTemplate.dto.comment;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentSaveRequestDto {
    private String content;
    private Long parent_id;
    private Long user_id;
}
