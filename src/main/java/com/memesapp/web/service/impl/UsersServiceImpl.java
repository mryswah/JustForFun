package com.memesapp.web.service.impl;

import com.memesapp.web.dto.UsersDto;
import com.memesapp.web.model.Roles;
import com.memesapp.web.model.Users;
import com.memesapp.web.repository.RolesRepository;
import com.memesapp.web.repository.UsersRepository;
import com.memesapp.web.security.SecurityUtil;
import com.memesapp.web.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.memesapp.web.mapper.UsersMapper.mapToUsers;
import static com.memesapp.web.mapper.UsersMapper.mapToUsersDto;

@Service
public class UsersServiceImpl implements UsersService {
    private UsersRepository usersRepository;
    private RolesRepository rolesRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UsersServiceImpl(UsersRepository usersRepository, RolesRepository rolesRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.rolesRepository = rolesRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void registerUser(UsersDto usersDto) {
        Users users = mapToUsers(usersDto);
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        Roles roles = rolesRepository.findByName("USER");
        users.setRoles(Arrays.asList(roles));
        usersRepository.save(users);
    }

    @Override
    public Users login(String username, String password) {
        return usersRepository.login(username,password);
    }

    @Override
    public Users searchByUsername(String username) {
        return usersRepository.searchByUsername(username);
    }

    @Override
    public List<UsersDto> searchByUsernameAndEmail(String username, String email){
        List<Users> users = usersRepository.searchByUsernameAndEmail(username, email);
        return users.stream().map((user) -> mapToUsersDto(user)).collect(Collectors.toList());
    }

    @Override
    public void updateUser(UsersDto usersDto) {
        String username = SecurityUtil.getSessionUser();
        Users users = usersRepository.searchByUsername(username);
        users.setEmail(usersDto.getEmail());
        users.setUpdatedOn(LocalDateTime.now());
        usersRepository.save(users);
    }

    @Override
    public void updateUserPassword(UsersDto usersDto) {
        String username = SecurityUtil.getSessionUser();
        Users users = usersRepository.searchByUsername(username);
        users.setPassword(passwordEncoder.encode(usersDto.getPassword()));
        users.setUpdatedOn(LocalDateTime.now());
        usersRepository.save(users);
    }

    @Override
    public void deleteUser(Long usersid) {
        usersRepository.deleteById(usersid);
    }
}
