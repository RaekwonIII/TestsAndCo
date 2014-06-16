package com.Codility.Massimo;

public class MaxSlice {

	public int solution(int[] A){
		int maxEnding = A[0], maxSlice = A[0];
		
		for (int a : A) {
			maxEnding = Math.max(a,	maxEnding + a);
			maxSlice = Math.max(maxSlice, maxEnding);
		}
		
		return maxSlice;
	}
}
