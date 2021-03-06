package com.pedrolima.workshopmongo.services;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedrolima.workshopmongo.domain.Post;
import com.pedrolima.workshopmongo.repositories.PostRepository;
import com.pedrolima.workshopmongo.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;

	public Post findById(String id) {
		Optional<Post> user = repository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public List<Post> findByTitle(String title){
		return repository.findByTitle(title);
	}
	
	public List<Post> fullSearch(String text, LocalDate minDate, LocalDate maxDate){
		return repository.fullSearch(text, minDate, maxDate.plus(1, ChronoUnit.DAYS));
	}
}
