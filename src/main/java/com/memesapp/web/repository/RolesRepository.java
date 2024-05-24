package com.memesapp.web.repository;

import com.memesapp.web.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Roles, Long> {
    Roles findByName(String name);
}
