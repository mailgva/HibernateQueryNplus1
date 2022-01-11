package com.gorbatenko.db;

import com.gorbatenko.db.model.Post;
import com.gorbatenko.db.model.PostComment;
import com.gorbatenko.db.repository.PostJpaRepository;
import com.gorbatenko.db.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@SpringBootApplication
public class DbApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbApplication.class, args);
	}

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private PostJpaRepository postJpaRepository;

	@GetMapping("/")
	public List<Post> getPosts() {
		return postRepository.getPosts(); // Query for each post
	}

	@GetMapping("/posts")
	public List<Post> getPostsOneQuery() {
		return postJpaRepository.getPostsWithComments(); // One query
	}

	@GetMapping("/comments")
	public List<PostComment> getComments() {
		return postRepository.getPostComments();
	}
}
