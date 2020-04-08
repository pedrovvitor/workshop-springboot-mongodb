package com.pedrolima.workshopmongo.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.pedrolima.workshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {

	@Query("{ 'title' : { $regex: ?0, $options: 'i' } }")
	List<Post> findByTitle(String title);

	List<Post> findByTitleContainingIgnoreCase(String title);

	@Query("{ $and: [ { instant: {$gte: ?1 } }, { instant: {$lte: ?2 } }, {$or: [ {'title': { $regex: ?0, $options: 'i' } }, {'body': { $regex: ?0, $options: 'i'  } }, {'comments.text': { $regex: ?0, $options: 'i'  } } ]  }] }")
	List<Post> fullSearch(String text, LocalDate minDate, LocalDate maxDate);
}
