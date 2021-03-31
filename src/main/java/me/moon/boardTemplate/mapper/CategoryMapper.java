package me.moon.boardTemplate.mapper;

import me.moon.boardTemplate.dto.category.ResponseCategoriesDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {
    boolean toExistCategoryById(Long id);
    boolean toExistCategoryByName(String name);
    List<ResponseCategoriesDto> getCategories();
    void insertCategory(String name);
    void updateCategory(Long id, String name);
    void deleteCategory(Long id);
}
