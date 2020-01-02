package com.fernandaviana.projetomongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.fernandaviana.projetomongo.domain.Post;
import com.fernandaviana.projetomongo.domain.User;
import com.fernandaviana.projetomongo.dto.AthorDTO;
import com.fernandaviana.projetomongo.dto.CommentDTO;
import com.fernandaviana.projetomongo.interfaces.PostRepository;
import com.fernandaviana.projetomongo.interfaces.UserRepository;

@Configuration
public class Instatiation implements CommandLineRunner{
	
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
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com");
		User u2 = new User(null, "Alex Costa", "alexc@gmail.com");
		User u3 = new User(null, "Carlos Magno", "carlosmgn@gmail.com");
		User u4 = new User(null, "Fernanda Viana", "fviana@gmail.com");
		
		userRepository.saveAll(Arrays.asList(u1, u2, u3, u4));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu Viagem", "Vou viajar para NY", new AthorDTO(u1));
		Post post2 = new Post(null, sdf.parse("09/10/2017"), "Partiu Férias", "Vou para Casa", new AthorDTO(u2));
		Post post3 = new Post(null, sdf.parse("09/10/2019"), "Partiu Aeroporto", "Ilha Bela", new AthorDTO(u4));
		
		CommentDTO c1 = new CommentDTO("Boa viagem", sdf.parse("23/03/2018"), new AthorDTO(u3));
		CommentDTO c2 = new CommentDTO("Aproveite", sdf.parse("30/09/2016"), new AthorDTO(u4));
		CommentDTO c3 = new CommentDTO("Tenha um ótimo dia", sdf.parse("01/02/2014"), new AthorDTO(u2));
		postRepository.saveAll(Arrays.asList(post1, post2, post3));
		
		post1.getComments().addAll(Arrays.asList(c1, c2));
		post2.getComments().addAll(Arrays.asList(c3));
		
		u1.getPosts().addAll(Arrays.asList(post1, post2));
		u3.getPosts().addAll(Arrays.asList(post2));
		u4.getPosts().addAll(Arrays.asList(post3));
		
		userRepository.saveAll(Arrays.asList(u1, u3, u4));
	}
	

}
