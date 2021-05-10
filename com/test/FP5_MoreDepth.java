package com.test;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FP5_MoreDepth {

	public static void main(String[] args) {
		List<Integer> li = List.of(2,6,7,8,9,12,15,16,19,22);
		List<String> courses = List.of("Spring Boot","Spring Cloud","Spring Security","Devops","ReactJS","VueJS","BackboneJS");
		printSpringCourses(courses);
		printAllNumbers(li);
		printAllEvenNumbers(li);
		
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
		
		
		//Predicator
		Predicate<Integer> predicate = new Predicate<Integer>() {
			@Override
			public boolean test(Integer t) {
				return t % 2 == 0;
			}
		};
		
		//Mapper
		Function<Integer,Integer> mapper = new Function<Integer, Integer>() {
			@Override
			public Integer apply(Integer t) {
				return t*2;
			}
		};
		
		//Consumer
		Consumer<Integer> action = new Consumer<Integer>() {
			@Override
			public void accept(Integer t) {
				System.out.println(t);
			}
		};	
		
		numbers.stream()//convert to stream
			.filter(predicate)		//predicator
			.map(mapper)			//mapper
			.forEach(action);		//consumer with static method reference
	}
	

}










