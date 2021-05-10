package com.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


class Course {
	private String courseName;
	private String category;
	private int reviewScore;
	private int noOfStudents;
	
	
	public Course(String courseName, String category, int reviewScore, int noOfStudents) {
		super();
		this.courseName = courseName;
		this.category = category;
		this.reviewScore = reviewScore;
		this.noOfStudents = noOfStudents;
	}
	
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getReviewScore() {
		return reviewScore;
	}
	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}
	public int getNoOfStudents() {
		return noOfStudents;
	}
	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}
	
	public String toString() {
		return courseName + ":" + category + ":" + reviewScore + ":" + noOfStudents;
	}

	
}

public class FP8_CustomClassOperations {
	
	
   @SuppressWarnings("unused")
	public static void main(String[] args) {
		List<Course> courses = List.of(
				new Course("Spring","Framework",98,20000),
				new Course("Spring Boot","Framework",95,18000),
				new Course("API","Microservices",97,22000),
				new Course("Microservices","Microservices",96,25000),
				new Course("FullStack","FullStack",91,14000),
				new Course("AWS","Cloud",92,21000),
				new Course("Azure","Cloud",99,21000),
				new Course("Docker","Cloud",92,20000),
				new Course("Kubernetes","Cloud",91,20000)
				);
		
		//allMatch
		Predicate<Course> courseReviewGreaterThan90 = course->course.getReviewScore()>90;
		System.out.println(courses.stream().allMatch(courseReviewGreaterThan90));
		
		//anyMatch
		System.out.println(courses.stream().anyMatch(course -> course.getReviewScore()>100));
		
		//noneMatch
		System.out.println(courses.stream().noneMatch(courseReviewGreaterThan90));
		
		//comparators
		Comparator<Course> comparingByNoOfStudents = Comparator.comparing(Course::getNoOfStudents);
		Comparator<Course> comparingByNoOfStudentsReversed = Comparator.comparing(Course::getNoOfStudents).reversed();
		System.out.println(courses.stream()
				.sorted(comparingByNoOfStudents)
				.collect(Collectors.toList()));
		//result: [FullStack:FullStack:91:14000, Spring Boot:Framework:95:18000, Spring:Framework:98:20000, Docker:Cloud:92:20000, Kubernetes:Cloud:91:20000, AWS:Cloud:92:21000, Azure:Cloud:99:21000, API:Microservices:97:22000, Microservices:Microservices:96:25000]
		System.out.println(courses.stream()
				.sorted(comparingByNoOfStudents
						.reversed())
				.collect(Collectors.toList()));
		//result: [Microservices:Microservices:96:25000, API:Microservices:97:22000, AWS:Cloud:92:21000, Azure:Cloud:99:21000, Spring:Framework:98:20000, Docker:Cloud:92:20000, Kubernetes:Cloud:91:20000, Spring Boot:Framework:95:18000, FullStack:FullStack:91:14000]
		Comparator<Course> comparingByNoOfStudentsAndNoOfReviews = Comparator.comparing(Course::getNoOfStudents).thenComparing(Course::getReviewScore);
		System.out.println(courses.stream()
				.sorted(comparingByNoOfStudentsReversed)
				.collect(Collectors.toList()));
		//result:[Microservices:Microservices:96:25000, API:Microservices:97:22000, Azure:Cloud:99:21000, AWS:Cloud:92:21000, Spring:Framework:98:20000, Docker:Cloud:92:20000, Kubernetes:Cloud:91:20000, Spring Boot:Framework:95:18000, FullStack:FullStack:91:14000]
		
		//skip
		System.out.println(courses.stream()
				.sorted(comparingByNoOfStudentsReversed).collect(Collectors.toList()));
		System.out.println("Skipped: "+courses.stream()
				.sorted(comparingByNoOfStudentsReversed)
				.skip(3).collect(Collectors.toList()));
		
		//limit
		System.out.println("Limited: "+courses.stream()
				.sorted(comparingByNoOfStudentsReversed)
				.limit(5).collect(Collectors.toList()));
		
		//takeWhile
		System.out.println("TakeWhile: "+courses.stream()
				.takeWhile(course->course.getReviewScore()<99).collect(Collectors.toList()));
		
		//dropWhile
		System.out.println("DropWhile: "+courses.stream()
				.dropWhile(course->course.getReviewScore()>97).collect(Collectors.toList()));
		
		//max
		System.out.println("Maximum: "+courses.stream()
		.max(Comparator.comparing(Course::getNoOfStudents)));
		
		//min
		System.out.println("Minimum: "+courses.stream()
		.min(Comparator.comparing(Course::getNoOfStudents)));
		
		//findFirst
		System.out.println("FindFirst: "+courses.stream()
		.takeWhile(course->course.getReviewScore()<99).findFirst());
		
		//findAny
		System.out.println("FindAny: "+courses.stream()
		.takeWhile(course->course.getReviewScore()<99).findAny());
		
		//sum
		System.out.println("Sum: "+courses.stream()
		.filter(course->course.getReviewScore()<99)
		.mapToInt(Course::getNoOfStudents).sum());
		
		//count
		System.out.println("Count: "+courses.stream()
		.filter(course->course.getReviewScore()<99)
		.mapToInt(Course::getNoOfStudents).count());
		
		//average
		System.out.println("Average: "+courses.stream()
		.filter(course->course.getReviewScore()<99)
		.mapToInt(Course::getNoOfStudents).average());
		
		//grouping using collectors
		System.out.println("GroupingBy: "+courses.stream()
		.collect(Collectors.groupingBy(Course::getCategory)));
		System.out.println("GroupingBy with count: "+courses.stream()
		.collect(Collectors.groupingBy(Course::getCategory,Collectors.counting())));
		System.out.println("GroupingBy with maxby: "+courses.stream()
		.collect(Collectors.groupingBy(Course::getCategory,Collectors.maxBy(Comparator.comparing(Course::getReviewScore)))));
		System.out.println("GroupingBy with  mapping name: "+courses.stream()
		.collect(Collectors.groupingBy(Course::getCategory,Collectors.mapping(Course::getCourseName, Collectors.toList()))));
		
		//creating stream from Array
//		Method1
		Stream.of(12,9,5,7,11,15,16,19,22,27);
//		Method2
		int[] numberArray = {12,9,5,7,11,15,16,19,22,27};
		Arrays.stream(numberArray)
		.filter(number->number%2==0)
		.forEach(System.out::println);
		
		System.out.println("Int Array Max: "+Arrays.stream(numberArray).max());
		System.out.println("Int Array Count: "+Arrays.stream(numberArray).count());
		System.out.println("Int Array Average: "+Arrays.stream(numberArray).average());
		
//		creating streams only for ints
		System.out.println("Sum From IntStream:: "+IntStream.range(0, 9).sum());
		System.out.println("Average from Intstream:: "+IntStream.range(0, 9).average());
		
//		Other utilities from Intstream
		System.out.println("Iterating Intstream::"+IntStream.iterate(1, e->e+2).limit(10).sum());
		IntStream.iterate(2, e->e+2).peek(System.out::println).limit(10);
				
		
	}

}










