package me.moon.boardTemplate.mapper;

import me.moon.boardTemplate.dto.post.PostListResponseDto;
import me.moon.boardTemplate.dto.post.PostResponseDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {
    boolean toExistPostById(Long id);
    boolean toExistTempPostById(Long id);
    void insertPost(Long userId, Long categoryId, String title, String content, String image);
    void insertTempPost(Long userId, Long categoryId, String title, String content, String image);
    void insertTempPostToPost(Long id);
    void updatePost(Long id, Long categoryId, String title, String content, String image);
    void deletePost(Long id);
    PostResponseDto getOnePost(Long id);
    List<PostListResponseDto> getPostList();
    List<PostListResponseDto> searchedPostsByTitle(String title);
    List<PostListResponseDto> searchedPostsByTitleAndContent(String titleContent);
}
