package com.Codility.Massimo;

public class MaxDoubleSlice {

	// Get the sum of maximum subarray, which ends this position
    // Method: http://en.wikipedia.org/wiki/Maximum_subarray_problem
	public int solution(int[] A) {
        // write your code in Java SE 7
		
		int maxEndingTemp = 0;
		int[] maxEnding = new int[A.length];
		
		for (int i = 1; i < A.length-1; i++) {
			maxEndingTemp = Math.max(0,	maxEndingTemp + A[i]);
			maxEnding[i] = maxEndingTemp;
		}
		
		int maxBeginningTemp = 0;
		int[] maxBeginning = new int[A.length];
		// run the array reverse, to find max sum beginning at index i
		for (int i = A.length - 2; i > 0; i--) {
			maxBeginningTemp = Math.max(0,	maxBeginningTemp + A[i]);
			maxBeginning[i] = maxBeginningTemp;
		}
		
		int maxDoubleSlice = 0;
		// join the two slices by adding the max sum of the slice that ends
		// ad index i and the maximum sum of the slice that begins at i+2
		for(int i = 0; i < A.length - 2; i++){
			maxDoubleSlice = Math.max(maxDoubleSlice, maxEnding[i] + maxBeginning[i+2]);
		}
		
		return maxDoubleSlice;
    }
}
