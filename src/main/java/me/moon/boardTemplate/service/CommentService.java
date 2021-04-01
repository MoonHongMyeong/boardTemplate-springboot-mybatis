package me.moon.boardTemplate.service;

import lombok.RequiredArgsConstructor;
import me.moon.boardTemplate.dto.comment.CommentResponseDto;
import me.moon.boardTemplate.dto.comment.CommentSaveRequestDto;
import me.moon.boardTemplate.dto.comment.CommentUpdateRequestDto;
import me.moon.boardTemplate.mapper.CommentMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentMapper commentMapper;
    @Transactional(readOnly = true)
    public List<CommentResponseDto> getCommentList(Long postId) {
        return commentMapper.getCommentList(postId);
    }
    @Transactional
    public void insertComment(Long postId, CommentSaveRequestDto requestDto) {
        Long userId = requestDto.getUser_id();
        String content = requestDto.getContent();
        commentMapper.insertComment(content, userId, postId);
    }
    @Transactional
    public void insertReplies(Long postId, Long parentId, CommentSaveRequestDto requestDto) {
        Long userId = requestDto.getUser_id();
        String content = requestDto.getContent();
        commentMapper.insertReplies(content, parentId, userId, postId);
    }
    @Transactional
    public void updateComment(Long commentId, CommentUpdateRequestDto requestDto) {
        if(!toExistCommentById(commentId)){
            throw new IllegalArgumentException("존재하지 않는 댓글 입니다.");
        }
        commentMapper.updateComment(commentId, requestDto.getContent());
    }

    private boolean toExistCommentById(Long commentId) {
        return commentMapper.toExistCommentById(commentId);
    }

    @Transactional
    public void deleteComment(Long commentId) {
        if(!toExistCommentById(commentId)){
            throw new IllegalArgumentException("존재하지 않는 댓글 입니다.");
        }
        commentMapper.deleteComment(commentId);
    }
}
