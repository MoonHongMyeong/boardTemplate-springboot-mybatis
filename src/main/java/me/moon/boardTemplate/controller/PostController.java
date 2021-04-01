package me.moon.boardTemplate.controller;

import lombok.RequiredArgsConstructor;
import me.moon.boardTemplate.dto.post.PostListResponseDto;
import me.moon.boardTemplate.dto.post.PostResponseDto;
import me.moon.boardTemplate.dto.post.PostSaveRequestDto;
import me.moon.boardTemplate.dto.post.PostUpdateRequestDto;
import me.moon.boardTemplate.service.PostService;
import me.moon.boardTemplate.utils.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/post")
public class PostController {
    private final PostService postService;
    //포스트 등록
    @PostMapping
    public ResponseEntity insertPost(@RequestBody PostSaveRequestDto requestDto){
        postService.insertPost(requestDto);
        return new ResponseEntity(new Message("포스트 등록 성공!"), HttpStatus.CREATED);
    }
    //임시 포스트 등록
    @PostMapping("/temp")
    public ResponseEntity insertTempPost(@RequestBody PostSaveRequestDto requestDto){
        postService.insertTempPost(requestDto);
        return new ResponseEntity(new Message("포스트 임시 등록 성공!"), HttpStatus.CREATED);
    }
    //임시 포스트를 포스트로 저장
    @PutMapping("/{postId}/save")
    public ResponseEntity insertTempPostToPost(@PathVariable("postId")Long id){
        postService.insertTempPostToPost(id);
        return new ResponseEntity(new Message("포스트 등록 성공!"), HttpStatus.OK);
    }
    //포스트 수정
    @PutMapping("/{postId}")
    public ResponseEntity updatePost(@PathVariable("postId")Long id, @RequestBody PostUpdateRequestDto requestDto){
        postService.updatePost(id, requestDto);
        return new ResponseEntity(new Message("포스트 수정 성공!"), HttpStatus.OK);
    }
    //포스트 삭제
    @DeleteMapping("/{postId}")
    public ResponseEntity deletePost(@PathVariable("postId")Long id){
        postService.deletePost(id);
        return new ResponseEntity(new Message("포스트 삭제 성공"), HttpStatus.OK);
    }
    //포스트 조회
    @GetMapping("/{postId}")
    public ResponseEntity getOnePost(@PathVariable("postId")Long id){
        PostResponseDto responseDto = postService.getOnePost(id);
        return new ResponseEntity(responseDto, HttpStatus.OK);
    }
    //포스트 리스트 조회
    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchedPostsByTitleAndContent(@RequestParam(value="title", required = false)String title, @RequestParam(value = "titleContent", required = false) String titleContent){
        //포스트 검색 (제목)
        if(title != null){
            List<PostListResponseDto> searchedPostList = postService.searchedPostsByTitle(title);
            return new ResponseEntity(searchedPostList, HttpStatus.OK);
        //포스트 검색 (제목 + 내용)
        }else if(titleContent != null){
            List<PostListResponseDto> searchedPostList = postService.searchedPostsByTitleAndContent(titleContent);
            return new ResponseEntity(searchedPostList, HttpStatus.OK);
        //포스트 리스트
        }else{
            List<PostListResponseDto> postList = postService.getPostList();
            return new ResponseEntity(postList, HttpStatus.OK);
        }
    }
}
