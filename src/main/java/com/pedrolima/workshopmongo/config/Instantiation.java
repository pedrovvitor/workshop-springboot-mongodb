package com.pedrolima.workshopmongo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.pedrolima.workshopmongo.domain.Post;
import com.pedrolima.workshopmongo.domain.User;
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
		
		Post post1 = new Post(null, Instant.parse("2019-06-20T19:53:07Z"), "Partiu viagem", "Vou viajar para São Paulo, abraços!", maria);
		Post post2 = new Post(null, Instant.parse("2019-06-20T08:53:07Z"), "Bom dia!", "Acordei feliz hoje!", maria);
		
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		postRepository.saveAll(Arrays.asList(post1, post2));
	}

}
