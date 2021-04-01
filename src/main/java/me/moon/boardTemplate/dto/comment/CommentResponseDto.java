package me.moon.boardTemplate.dto.comment;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentResponseDto {
    private Long id;
    private String Content;
    private Long parent_id;
    private String modified_date;
    private Long user_id;
    private String userName;
    private Long post_id;

}
