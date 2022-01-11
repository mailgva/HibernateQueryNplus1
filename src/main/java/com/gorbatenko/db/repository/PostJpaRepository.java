package com.gorbatenko.db.repository;

import com.gorbatenko.db.model.Post;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostJpaRepository extends JpaRepository<Post, Integer> {
    @EntityGraph(attributePaths = {"comments"}, type = EntityGraph.EntityGraphType.LOAD)
    @Query("SELECT p FROM Post p ORDER BY id")
    List<Post> getPostsWithComments();
}