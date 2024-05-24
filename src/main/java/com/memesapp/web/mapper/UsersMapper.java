package com.memesapp.web.mapper;

import com.memesapp.web.dto.UsersDto;
import com.memesapp.web.model.Users;

public class UsersMapper {
    public static Users mapToUsers(UsersDto usersDto){
        Users users = Users.builder()
                .id(usersDto.getId())
                .name(usersDto.getName())
                .username(usersDto.getUsername())
                .password(usersDto.getPassword())
                .email(usersDto.getEmail())
                .createdOn(usersDto.getCreatedOn())
                .updatedOn(usersDto.getUpdatedOn())
                .build();

        return users;
    }

    public static UsersDto mapToUsersDto(Users users){
        UsersDto usersDto = UsersDto.builder()
                .id(users.getId())
                .name(users.getName())
                .username(users.getUsername())
                .password(users.getPassword())
                .email(users.getEmail())
                .createdOn(users.getCreatedOn())
                .updatedOn(users.getUpdatedOn())
                .build();

        return usersDto;
    }
}
