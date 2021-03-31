package me.moon.boardTemplate.service;

import lombok.RequiredArgsConstructor;
import me.moon.boardTemplate.dto.category.ResponseCategoriesDto;
import me.moon.boardTemplate.mapper.CategoryMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryMapper categoryMapper;

    //카테고리 목록 조회
    public List<ResponseCategoriesDto> getCategories() {
        return categoryMapper.getCategories();
    }
    //카테고리 등록
    public void insertCategory(String name) {
        if(toExistCategoryByName(name)){
            throw new IllegalArgumentException("해당 카테고리는 이미 존재합니다.");
        }
        categoryMapper.insertCategory(name);
    }
    //카테고리 수정
    public void updateCategory(Long id, String name) {
        if(!toExistCategoryById(id)){
            throw new IllegalArgumentException("해당 캬테고리는 존재하지 않습니다.");
        }
        categoryMapper.updateCategory(id, name);
    }
    //아이디로 카테고리 존재 여부 확인
    private boolean toExistCategoryById(Long id) {
        return categoryMapper.toExistCategoryById(id);
    }
    //이름으로 카테고리 존재 여부 확인
    private boolean toExistCategoryByName(String name) {
        return categoryMapper.toExistCategoryByName(name);
    }
    //카테고리 삭제
    public void deleteCategory(Long id) {
        if(!toExistCategoryById(id)){
            throw new IllegalArgumentException("해당 캬테고리는 존재하지 않습니다.");
        }
        categoryMapper.deleteCategory(id);
    }
}
