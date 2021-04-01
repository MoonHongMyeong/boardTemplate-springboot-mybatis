package me.moon.boardTemplate.service;

import lombok.RequiredArgsConstructor;
import me.moon.boardTemplate.dto.post.PostListResponseDto;
import me.moon.boardTemplate.dto.post.PostResponseDto;
import me.moon.boardTemplate.dto.post.PostSaveRequestDto;
import me.moon.boardTemplate.dto.post.PostUpdateRequestDto;
import me.moon.boardTemplate.mapper.PostMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostMapper postMapper;

    @Transactional
    public void insertPost(PostSaveRequestDto requestDto) {
        Long userId = requestDto.getUser_id();
        Long categoryId = requestDto.getCategory_id();
        String title = requestDto.getTitle();
        String content = requestDto.getContent();
        String image = requestDto.getImage();
        postMapper.insertPost(userId,categoryId,title,content,image);
    }
    @Transactional
    public void insertTempPost(PostSaveRequestDto requestDto) {
        Long userId = requestDto.getUser_id();
        Long categoryId = requestDto.getCategory_id();
        String title = requestDto.getTitle();
        String content = requestDto.getContent();
        String image = requestDto.getImage();
        postMapper.insertTempPost(userId,categoryId,title,content,image);
    }
    @Transactional
    public void insertTempPostToPost(Long id) {
        postMapper.insertTempPostToPost(id);
    }
    @Transactional
    public void updatePost(Long id, PostUpdateRequestDto requestDto) {
        if(!toExistPostById(id)){
            throw new IllegalArgumentException("해당 포스트가 존재하지 않습니다.");
        }
        if(toExistTempPostById(id)){
            throw new IllegalArgumentException("해당 포스트는 임시 포스트 입니다.");
        }
        Long categoryId = requestDto.getCategory_id();
        String title = requestDto.getTitle();
        String content = requestDto.getContent();
        String image = requestDto.getImage();
        postMapper.updatePost(id,categoryId,title,content,image);
    }

    @Transactional
    public void deletePost(Long id) {
        if(!toExistPostById(id)){
            throw new IllegalArgumentException("이미 삭제 된 포스트 입니다.");
        }
        postMapper.deletePost(id);
    }

    private boolean toExistPostById(Long id) {
        return postMapper.toExistPostById(id);
    }

    private boolean toExistTempPostById(Long id) {
        return postMapper.toExistTempPostById(id);
    }

    @Transactional(readOnly = true)
    public PostResponseDto getOnePost(Long id) {
        if(!toExistPostById(id)){
            throw new IllegalArgumentException("삭제 된 포스트 입니다.");
        }
        if(toExistTempPostById(id)){
            throw new IllegalArgumentException("해당 포스트는 임시저장 된 포스트 입니다.");
        }
        return postMapper.getOnePost(id);
    }
    @Transactional(readOnly = true)
    public List<PostListResponseDto> getPostList() {
        return postMapper.getPostList();
    }
    @Transactional(readOnly = true)
    public List<PostListResponseDto> searchedPostsByTitle(String title) {
        return postMapper.searchedPostsByTitle(title);
    }
    @Transactional(readOnly = true)
    public List<PostListResponseDto> searchedPostsByTitleAndContent(String titleContent) {
        return postMapper.searchedPostsByTitleAndContent(titleContent);
    }


}
