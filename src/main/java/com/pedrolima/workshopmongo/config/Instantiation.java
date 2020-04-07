package com.pedrolima.workshopmongo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.pedrolima.workshopmongo.domain.Post;
import com.pedrolima.workshopmongo.domain.User;
import com.pedrolima.workshopmongo.dto.AuthorDTO;
import com.pedrolima.workshopmongo.dto.CommentDTO;
import com.pedrolima.workshopmongo.repositories.PostRepository;
import com.pedrolima.workshopmongo.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {

		userRepository.deleteAll();
		postRepository.deleteAll();
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");

		userRepository.saveAll(Arrays.asList(maria, alex, bob));

		Post post1 = new Post(null, Instant.parse("2019-06-20T19:53:07Z"), "Partiu viagem",
				"Vou viajar para São Paulo, abraços!", new AuthorDTO(maria));
		Post post2 = new Post(null, Instant.parse("2019-06-20T08:53:07Z"), "Bom dia!", "Acordei feliz hoje!",
				new AuthorDTO(maria));

		CommentDTO comment1 = new CommentDTO("Boa viagem mano!", Instant.now(), new AuthorDTO(alex));
		CommentDTO comment2 = new CommentDTO("Aproveite!", Instant.now(), new AuthorDTO(bob));
		CommentDTO comment3 = new CommentDTO("Tenha um ótimo dia.", Instant.now(), new AuthorDTO(alex));

		post1.getComments().addAll(Arrays.asList(comment1, comment2));
		post2.getComments().add(comment3);
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		maria.getPosts().addAll(Arrays.asList(post1, post2));

		userRepository.save(maria);
	}

}
