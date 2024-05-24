package com.memesapp.web.repository;

import com.memesapp.web.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Long> {
    @Query("SELECT c from Users c WHERE (c.username=:username OR c.email=:username) AND c.password=:password")
    Users login(String username, String password);
    Users searchByUsername(String username);
    @Query("SELECT c from Users c WHERE (c.username=:username) OR (c.email=:email)")
    List<Users> searchByUsernameAndEmail(String username, String email);
}
