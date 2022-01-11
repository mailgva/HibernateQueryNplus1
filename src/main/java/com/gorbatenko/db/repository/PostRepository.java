package com.gorbatenko.db.repository;

import com.gorbatenko.db.model.Post;
import com.gorbatenko.db.model.PostComment;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PostRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Post> getPosts() {
        return em.createQuery("SELECT p FROM Post p", Post.class)
                .getResultList();
    }

    public List<PostComment> getPostComments() {
        return em.createQuery("SELECT pc FROM PostComment pc JOIN FETCH pc.post p", PostComment.class)
                .getResultList();
    }

}