package com.Codility.Massimo;

public class MinPerimeterRectangle {
	public int solution(int N) {
        // write your code in Java SE 7
        
		
		int start = (int) Math.floor(Math.sqrt(N));
		int i;
		for (i = start; i > 0; i--) {
			if (N % i == 0) {
				break;
			}
		}
		
		return (i + N / i) * 2;
    }
}
