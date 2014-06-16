package com.Codility.Massimo;

import java.util.Arrays;

public class MaxProductOfThree {

	public int solution(int[] A) {
		// write your code in Java SE 7
		
		Arrays.sort(A);
		//do a merge sort here for exercise plz!
		
		int right = A[A.length-1] * A[A.length-2] * A[A.length-3];
		int left = A[A.length-1] * A[0] * A[1];
		
		return left > right ? left : right;
    }
}
