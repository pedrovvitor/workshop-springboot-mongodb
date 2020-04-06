package com.pedrolima.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pedrolima.workshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {

}
