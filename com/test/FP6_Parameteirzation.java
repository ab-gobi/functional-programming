package com.test;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FP6_Parameteirzation {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(2,6,7,8,9,12,15,16,19,22);
		Predicate<Integer> iseven = x -> x%2 == 0;
		Predicate<Integer> isOdd = x -> x%2 != 0;
		Function<Integer, Integer> mapper = x -> x+x;
		System.out.println(action(numbers, iseven,mapper));
	}

	private static List<Integer> action(List<Integer> numbers,Predicate<Integer> predicator,Function<Integer, Integer> mapper) {
		List<Integer> newNumbers = 
		numbers.stream()//convert to stream
		.filter(predicator)
		.map(mapper)//predicator
		.collect(Collectors.toList());
		return newNumbers;
	}

}










