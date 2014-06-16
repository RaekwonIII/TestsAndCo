package com.Codility.Massimo;

public class Prediction {

	public static void compute_prediction(Integer n, Integer w) {
        // Write your code here
        // To print results to the standard output please use System.out.println
        // Example: System.out.println("Hello world!");
		final float increaseRate = 0.07f;
		
		double temp = n;
		for (int i = 0; i < w; i++){
			temp = temp + temp * increaseRate;
		}
		
		System.out.println((int) temp);
    }
}
