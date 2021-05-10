package com.test;

import java.util.List;

public class FP1_Intro {

	public static void main(String[] args) {
		List<Integer> li = List.of(2,6,7,8,9,12,15,16,19,22);
		List<String> courses = List.of("Spring Boot","Spring Cloud","Spring Security","Devops","ReactJS","VueJS","BackboneJS");
		printSpringCourses(courses);
//		printAllEvenNumbers(li);
		
	}
	
	private static void printSpringCourses(List<String> courses) {
		courses.stream()
		.filter(course -> course.contains("Spring"))
		.map(course -> course + " "+course.length())
		.forEach(System.out::println);
	}
	private static void printAllNumbers(List<Integer> numbers) {
		numbers.stream()
		.forEach(System.out::println);
	}
	
	private static void printAllEvenNumbers(List<Integer> numbers) {
		numbers.stream()//convert to stream
		.filter(number -> number%2 == 0)//predicator
		.map(number -> number*2)//mapper
		.forEach(System.out :: println);//consumer with static method reference
	}
	

}










