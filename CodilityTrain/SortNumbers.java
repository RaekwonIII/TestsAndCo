package com.Codility.Massimo;

public class SortNumbers {

	public static void sort_locations(Integer a, Integer b, Integer c) {
		// Write your code here
		// To print results to the standard output please use System.out.println
		// Example: System.out.println("Hello world!");

		if(a > b){
			Integer temp = b;
			b = a;
			a = temp;
		}
		
		if(b > c){
			Integer temp = c;
			c = b;
			b = temp;
		}
		
		if(a > b){
			Integer temp = b;
			b = a;
			a = temp;
		}
		
		System.out.println(a + " " + b + " " + c);

	}

}
