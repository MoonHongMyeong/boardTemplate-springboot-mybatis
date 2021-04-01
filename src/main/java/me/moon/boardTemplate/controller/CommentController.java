package me.moon.boardTemplate.controller;

import lombok.RequiredArgsConstructor;
import me.moon.boardTemplate.dto.comment.CommentResponseDto;
import me.moon.boardTemplate.dto.comment.CommentSaveRequestDto;
import me.moon.boardTemplate.dto.comment.CommentUpdateRequestDto;
import me.moon.boardTemplate.service.CommentService;
import me.moon.boardTemplate.utils.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/post")
public class CommentController {
    private final CommentService commentService;

    //댓글 리스트 조회
    @GetMapping("/{postId}/comments")
    public ResponseEntity getCommentList(@PathVariable("postId") Long postId){
        List<CommentResponseDto> commentList = commentService.getCommentList(postId);
        return new ResponseEntity(commentList, HttpStatus.OK);
    }
    //댓글 등록
    @PostMapping("/{postId}/comments")
    public ResponseEntity insertComment(@PathVariable("postId") Long postId, @RequestBody CommentSaveRequestDto requestDto){
        commentService.insertComment(postId, requestDto);
        return new ResponseEntity(new Message("댓글 등록 성공!"), HttpStatus.CREATED);
    }
    //대댓글 등록
    @PostMapping("/{postId}/comments/{commentId}")
    public ResponseEntity insertReplies(@PathVariable("postId") Long postId, @PathVariable("commentId") Long commentId, @RequestBody CommentSaveRequestDto requestDto){
        commentService.insertReplies(postId, commentId, requestDto);
        return new ResponseEntity(new Message("대댓글 등록 성공!"), HttpStatus.CREATED);
    }
    //댓글 수정
    @PutMapping("/{postId}/comments/{commentId}")
    public ResponseEntity updateComment(@PathVariable("postId") Long postId, @PathVariable("commentId")Long commentId, @RequestBody CommentUpdateRequestDto requestDto){
        commentService.updateComment(commentId, requestDto);
        return new ResponseEntity(new Message("댓글 수정 성공!"), HttpStatus.OK);
    }
    //댓글 삭제
    @DeleteMapping("/{postId}/comments/{commentId}")
    public ResponseEntity deleteComment(@PathVariable("postId") Long postId, @PathVariable("commentId") Long commentId){
        commentService.deleteComment(commentId);
        return new ResponseEntity(new Message("댓글 삭제 성공!"), HttpStatus.OK);
    }
}
