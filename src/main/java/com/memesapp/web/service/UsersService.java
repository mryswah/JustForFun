package com.memesapp.web.service;

import com.memesapp.web.dto.UsersDto;
import com.memesapp.web.model.Users;

import java.util.List;

public interface UsersService {

    void registerUser(UsersDto usersDto);
    Users login(String username, String password);
    Users searchByUsername(String username);
    List<UsersDto> searchByUsernameAndEmail(String username, String email);
    void updateUser(UsersDto usersDto);
    void updateUserPassword(UsersDto usersDto);
    void deleteUser(Long usersid);
}
