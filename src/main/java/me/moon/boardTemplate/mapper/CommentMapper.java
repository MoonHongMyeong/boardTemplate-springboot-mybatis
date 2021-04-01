package me.moon.boardTemplate.mapper;

import me.moon.boardTemplate.dto.comment.CommentResponseDto;
import me.moon.boardTemplate.dto.comment.CommentSaveRequestDto;
import me.moon.boardTemplate.dto.comment.CommentUpdateRequestDto;

import java.util.List;

public interface CommentMapper {
    List<CommentResponseDto> getCommentList(Long postId);
    void insertComment(String content, Long userId, Long postId);
    void insertReplies(String content, Long parentId, Long userId, Long postId);
    void updateComment(Long commentId, String content);
    void deleteComment(Long commentId);
    boolean toExistCommentById(Long commentId);

}
