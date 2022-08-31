package com.test;

import java.util.List;
import java.util.stream.Collectors;

public class
FP4_Collect {

	public static void main(String[] args) {
		List<Integer> li = List.of(2,6,55,7,8,9,12,15,16,19,22);
		List<Integer> evenLi = li.stream()
									.filter(number -> number%2 == 0)
									.collect(Collectors.toList());
		System.out.println(evenLi);
		System.out.println(evenLi);
	}
	

	
	

	
	

}










