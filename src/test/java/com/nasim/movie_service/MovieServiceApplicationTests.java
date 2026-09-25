package com.nasim.movie_service;

import com.nasim.movie_service.dto.MovieDto;
import com.nasim.movie_service.enity.Genre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;

import java.util.List;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
		properties = "spring.cloud.aws.secretsmanager.enabled=false"
)
class MovieServiceApplicationTests {
    private static final Logger log= LoggerFactory.getLogger(MovieServiceApplicationTests.class);

	@Value("${local.server.port}")
	private int port;

	private RestClient restClient;

	@BeforeEach
	void setUp() {
		log.info("the server port: {}",port);
		restClient = RestClient.builder()
				.baseUrl("http://localhost:" + port)
				.build();
	}

	@Test
	void contextLoads() {
	}
	@Test
	void health(){
		var responseEntity= restClient.get().uri(
				 "/actuator/health"
		 ).retrieve()
				 .toEntity(new ParameterizedTypeReference<Object>(){});
		Assertions.assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
	}
	@Test
	void allMovies(){
	  	var movies=this.getMovies("/api/movies");
		  Assertions.assertEquals(6,movies.size());
	}
	@Test
	void moviesByGenre(){
		var movies=this.getMovies("/api/movies/ACTION");
		Assertions.assertEquals(3,movies.size());
        Assertions.assertTrue(movies.stream().map(MovieDto::genre).allMatch(
				Genre.ACTION::equals
		));

	}
	private List<MovieDto> getMovies(String uri){
		var responseEntity=restClient.get()
				.uri(uri)
				.retrieve()
				.toEntity(new ParameterizedTypeReference<List<MovieDto>>(){});
		Assertions.assertNotNull(responseEntity.getBody());
		return responseEntity.getBody();
	}


}
