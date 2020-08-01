package com.cesarpereira.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.cesarpereira.workshopmongo.domain.Post;
import com.cesarpereira.workshopmongo.domain.User;
import com.cesarpereira.workshopmongo.dto.AuthorDTO;
import com.cesarpereira.workshopmongo.dto.ComentDTO;
import com.cesarpereira.workshopmongo.repository.PostRepository;
import com.cesarpereira.workshopmongo.repository.UserRepository;

@Configuration
public class Instatiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
		
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		userRepository.saveAll(Arrays.asList(maria,alex,bob));
		
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "PartiuViagem", "Vou Viajar para Sao Paulo Abraços.", new AuthorDTO(maria) );
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom Dia", "Vou Acordei feliz.", new AuthorDTO(maria) );
	
		ComentDTO c1 = new ComentDTO("Boa Viagem mano", sdf.parse("20/01/2020"), new AuthorDTO(alex));
		ComentDTO c2 = new ComentDTO("TESTE CESAR", sdf.parse("25/01/2020"), new AuthorDTO(bob));
		ComentDTO c3 = new ComentDTO("TESTE FRANCINBE", sdf.parse("24/01/2020"), new AuthorDTO(alex));
		
		post1.getComments().addAll(Arrays.asList(c1,c2));
		post1.getComments().addAll(Arrays.asList(c3));
		
		
		
		postRepository.saveAll(Arrays.asList(post1,post2));
	
		maria.getPosts().addAll(Arrays.asList(post1,post2));
		userRepository.save(maria);
		
		
	}

	
	
}
