package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest( webEnvironment =WebEnvironment.DEFINED_PORT)
class StudentControllerService {

	@LocalServerPort
	private int randomPort;
	@Test
	void getStudenttest() {
		String url = "http://localhost:"+ randomPort +"/";	
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List> entity = restTemplate.getForEntity(url, List.class);
		assertEquals(200, entity.getStatusCodeValue());
	
	}

}
