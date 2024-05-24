package com.memesapp.web.repository;

import com.memesapp.web.model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepository extends JpaRepository<Categories, Long> {

}
