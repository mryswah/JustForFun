package com.memesapp.web.repository;

import com.memesapp.web.model.Memes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemesRepository extends JpaRepository<Memes, Long> {
    @Query("SELECT c from Memes c WHERE UPPER(c.category) LIKE UPPER(CONCAT('%', :query, '%')) OR UPPER(c.labels) LIKE UPPER(CONCAT('%', :query, '%')) OR UPPER(c.title) LIKE UPPER(CONCAT('%', :query, '%')) ORDER BY c.createdOn DESC")
    List<Memes> searchMemes(String query);

    @Query("SELECT c from Memes c WHERE c.category=:query ORDER BY c.createdOn DESC")
    List<Memes> filterMemesByCategories(String query);

    @Query("SELECT c from Memes c WHERE c.labels=:query ORDER BY c.createdOn DESC")
    List<Memes> filterMemesByLabels(String query);

    @Query("SELECT c from Memes c WHERE c.createdBy=:query ORDER BY c.createdOn DESC")
    List<Memes> listAllMemesCreatedByUser(String query);
}
