package com.kaoud.todo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kaoud.todo.model.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    @JsonIgnore
    private List<Category> category;


}
