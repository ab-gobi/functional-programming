package com.test;

import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FP7_OtherFunctionalInterfaces {
   @SuppressWarnings("unused")
	public static void main(String[] args) {
		List<Integer> numbers = List.of(2,6,7,8,9,12,15,16,19,22);
		
		//Predicator -->Argument(Integer), return -> default boolean
		Predicate<Integer> predicate = x -> x%2 ==0;
		
		//Function
		Function<Integer, Integer> integerFunction = (x) -> x*x;
		Function<Integer, String> stringFunction = (x) -> x+" ";
		
		//Consumer --> no return type
		Consumer<Integer> consumer = x -> System.out.println(x);
		
		//Supplier --> No arguments but only returns the value that we want
		Supplier<Integer> supplier = new Supplier<Integer>() {
			
			@Override
			public Integer get() {
				Random random = new Random();
				return random.nextInt(100);
			}
		};
		
		//UnaryOperator
		UnaryOperator<Integer> unary = (x)-> x+3;
		
		//BinaryOperator
		BinaryOperator<Integer> binary = (x,y)-> x*3;
		
		//BiPredicator
		BiPredicate<Integer, String> biPredicate = (x,y)-> x>5 && y.equals("test");
		
		//BiFunction
		BiFunction<Integer, Integer, Integer> biFunction = (x,y) -> x+y;
		
		
		//BiConsumer
		//IntBinaryOperator
		//IntConsumer
		//IntFunction
		//IntPredicate
		//IntSupplier
		//IntToDoubleFunction
	}

}










