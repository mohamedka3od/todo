package com.kaoud.todo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kaoud.todo.model.User;
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
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    @JsonIgnore
    private List<CategoryDto> category;

    public static User toEntity(UserDto userDto){
        User user = new User();
        if(userDto.getUserName() != null){
            user.setUserName(userDto.getUserName());
        } if(userDto.getFirstName() != null){
            user.setFirstName(userDto.getFirstName());
        } if(userDto.getLastName() != null){
            user.setLastName(userDto.getLastName());
        } if(userDto.getPassword() != null){
            user.setPassword(userDto.getPassword());
        } if(userDto.getId() != null){
            user.setId(userDto.getId());
        } if(userDto.getCategory() != null){
            user.setCategory(userDto.getCategory().stream().map(CategoryDto::toEntity).collect(Collectors.toList()));
        }
        return user;
    }
    public static UserDto fromEntity(User user){
        return UserDto.builder()
                .id(user.getId())
                .userName(user.getUserName())
                .firstName(user.getFirstName())
                .password(user.getPassword())
                .category(user.getCategory() != null ? user.getCategory().stream().map(CategoryDto::fromEntity).collect(Collectors.toList()): null)
                .build();
    }


}
