package com.example.demo.service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;

@Service
public class StudentService {

	public ResponseEntity<List<Student>> getAllStudent() {
		return new ResponseEntity<List<Student>>(Arrays.asList(
				new Student(1,"Mohamed",new Date()),
				new Student(2,"Ahmed",new Date()),
				new Student(3,"Amr",new Date()),
				new Student(4,"Alaa",new Date()),
				new Student(5,"Mohab",new Date()),
				new Student(6,"Ali",new Date()),
				new Student(7,"Hossam",new Date()),
				new Student(8,"Arafa",new Date()),
				new Student(9,"Hazem",new Date())
				),HttpStatus.OK);
	}
	
}
