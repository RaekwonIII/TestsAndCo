package com.Codility.Massimo;

import java.util.Arrays;

public class BubbleSort {
	public static void sort_students(Integer[] numbers) {
        // Write your code here
        // To print results to the standard output please use System.out.println
        // Example: System.out.println("Hello world!");
        boolean changed = false;
        Integer temp;
        
        do {
            changed = false;
            for (int i = 0; i < numbers.length-1; i++) {
                if (numbers[i] > numbers[i+1]){
                    temp = numbers[i];
                    numbers[i] = numbers[i+1];
                    numbers[i+1] = temp;
                    
                    changed = true;
                }
            }
        } while (changed == true);
        
        for (int i = 0; i < numbers.length; i++){
            System.out.println(numbers[i]);
        }
    }
}
