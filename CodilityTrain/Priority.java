package com.Codility.Massimo;

public class Priority {

	public static void count_configurations(Integer a, Integer b, Integer c, Integer n) {
        // Write your code here
        // To print results to the standard output please use System.out.println
        // Example: System.out.println("Hello world!");
		
		int count = 0;
        
        for (int i = 0; i <= a; i++) {
            for (int j = 0; j <= b; j++) {
                for (int k = 0; k <= c; k++) {
                    if (i + j + k == n) { count++; }
                }
            }
        }
        
        System.out.println(count);
    }
}
