package me.moon.boardTemplate.controller;

import lombok.RequiredArgsConstructor;
import me.moon.boardTemplate.dto.category.CategorySaveRequestDto;
import me.moon.boardTemplate.dto.category.ResponseCategoriesDto;
import me.moon.boardTemplate.service.CategoryService;
import me.moon.boardTemplate.utils.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/category")
public class CategoryController {
    private final CategoryService categoryService;

    //카테고리 목록 조회
    @GetMapping()
    public ResponseEntity getCategories() {
        List<ResponseCategoriesDto> categories = categoryService.getCategories();
        return new ResponseEntity(categories, HttpStatus.OK);
    }

    //카테고리 등록
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity insertCategory(@RequestBody CategorySaveRequestDto requestDto) {
        categoryService.insertCategory(requestDto.getName());
        return new ResponseEntity(new Message("카테고리 등록 성공!"), HttpStatus.CREATED);
    }

    //카테고리 수정
    @PutMapping("/{categoryId}")
    public ResponseEntity updateCategory(@PathVariable("categoryId") Long id, @RequestBody CategorySaveRequestDto requestDto) {
        categoryService.updateCategory(id, requestDto.getName());
        return new ResponseEntity(new Message("카테고리 수정 성공!"), HttpStatus.OK);
    }

    //카테고리 삭제
    @DeleteMapping("/{categoryId}")
    public ResponseEntity deleteCategory(@PathVariable("categoryId") Long id) {
        categoryService.deleteCategory(id);
        return new ResponseEntity(new Message("카테고리 삭제 성공!"), HttpStatus.OK);
    }
}
