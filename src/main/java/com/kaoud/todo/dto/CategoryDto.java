package com.kaoud.todo.dto;

import com.kaoud.todo.model.Category;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;
import java.util.stream.Collectors;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryDto {
    private Long id;

    private String name;
    private String description;

    private UserDto user;

    private List<TodoDto> todoList;

    public static Category toEntity(CategoryDto categoryDto){
        Category category = new Category();
        if(categoryDto.getId()!=null){
            category.setId(categoryDto.getId());
        }
        if(categoryDto.getName()!=null) {
            category.setName(categoryDto.getName());
        }
        if(categoryDto.getDescription()!=null) {
            category.setDescription(categoryDto.getDescription());
        }
        category.setUser(UserDto.toEntity(categoryDto.getUser()));
        category.setTodoList(categoryDto.getTodoList() != null ? categoryDto.getTodoList().stream().map(TodoDto::toEntity).collect(Collectors.toList()) : null);
        return category;
    }
    public static CategoryDto fromEntity(Category category) {
        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
                .todoList(
                        category.getTodoList() != null ? category.getTodoList().stream().map(TodoDto::fromEntity).collect(Collectors.toList()) : null
                )
                .build();
    }
}
