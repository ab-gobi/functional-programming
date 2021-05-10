package com.test;

import java.util.List;

public class FP2_Reduce_Intro {

	public static void main(String[] args) {
		List<Integer> li = List.of(2,6,55,7,8,9,12,15,16,19,22);
		System.out.println("Sum of all Numbers from the list:-> "+addAllFunctional(li));
		System.out.println("Max Number from the list-> "+findMax(li));
		System.out.println("Min Number from the list-> "+findMin(li));
		//System.out.println("Sum of odd numbers->"+sumOfOddNumbers(li));
	}
	

	private static int sum(int a,int b) {
		return a + b;
	}
	
	private static int getMax(int a, int b) {
		return a>b?a:b;
	}
	
	private static int getMin(int a, int b) {
		return a>b?b:a;
	}
	
	//reduce method will accumulate the streams and gives single value
	private static int addAllFunctional(List<Integer> numbers) {
		return numbers.stream()//convert to stream
		.reduce(4, FP2_Reduce_Intro::sum); //With static method reference
		//.reduce(0,(a,b) -> (a+b)); //-->With Lambda expression
//		.reduce(0,Integer::sum); //With Implicit Sum function from Integer primitive
	}
	
	private static int findMax(List<Integer> numbers) {
		return numbers.stream()//convert to stream
		//.reduce(Integer.MIN_VALUE, exercise2::getMax);// With static method reference
		.reduce(Integer.MIN_VALUE,(a,b) -> a>b?a:b); //-->With Lambda expression
	}
	
	private static int findMin(List<Integer> numbers) {
		return numbers.stream()//convert to stream
		.reduce(Integer.MAX_VALUE, FP2_Reduce_Intro::getMin);// With static method reference
		//.reduce(Integer.MAX_VALUE,(a,b) -> a>b?b:a); //-->With Lambda expression
	}
	

	
	

}










