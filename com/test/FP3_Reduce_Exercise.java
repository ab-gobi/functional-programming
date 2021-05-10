package com.test;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class FP3_Reduce_Exercise {

	public static void main(String[] args) {
		List<Integer> li = List.of(2,6,55,7,8,9,12,7,15,16,19,6,22);
		List<String> courses = List.of("Spring Boot","Spring Cloud","Spring Security","Devops","ReactJS","VueJS","BackboneJS");
//		System.out.println("Sum of squared Numbers from the list:-> "+sumOfSquaredNumbers(li));
//		System.out.println("Sum of all odd numbers-> "+sumOfAllOddNumbers(li));
//		System.out.println("Sum of all even numbers-> "+sumOfAllEvenNumbers(li));
		//distinct(li);
		//sorted(courses);
		sortedByLength(courses);
	}
	

	private static int sum(int a,int b) {
		return a + b;
	}
	
	
	//reduce method will accumulate the streams and gives single value
	private static int sumOfSquaredNumbers(List<Integer> numbers) {
		return numbers.stream()//convert to stream
				.map(number -> number*number)
		.reduce(0,Integer::sum); //With Implicit Sum function from Integer primitive
	}
	
	private static int sumOfAllOddNumbers(List<Integer> numbers) {
		return numbers.stream()//convert to stream
				.filter(number -> number%2==1)//-->With Lambda expression
		.reduce(0,Integer::sum); 
	}
	
	private static int sumOfAllEvenNumbers(List<Integer> numbers) {
		return numbers.stream()//convert to stream
				.filter(number -> number%2==0)//-->With Lambda expression
		.reduce(0,Integer::sum); 
	}
	
	private static void distinct(List<Integer> numbers) {
		numbers.stream()//convert to stream
				.distinct()//-->With Lambda expression
		.forEach(System.out::println);
	}
	
	private static void sorted(List<String> courses) {
		courses.stream()//convert to stream
				.sorted(Comparator.reverseOrder()).forEach(System.out::println);
	}
	
	private static void sortedByLength(List<String> courses) {
		courses.stream()//convert to stream
				.sorted(Comparator.comparing(str -> str.length())).forEach(System.out::println);
	}
	
	
	

}










