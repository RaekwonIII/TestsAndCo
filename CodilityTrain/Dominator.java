package com.Codility.Massimo;

public class Dominator {

	public int solution(int[] A) {
		// write your code in Java SE 7

		if(A.length == 0)
			return -1;
		
		int stackSize = 0;
		int value = A[0];

		for (int k: A) {

			if (stackSize == 0) {
				stackSize += 1;
				value = k;
				
			} else if (value != k) {
				stackSize -= 1;
				
			} else {
				stackSize += 1;
				
			}
		}
		
		int candidate = -1;
		int leaderIndex = -1;
		
		if (stackSize > 0)
			candidate = value;
		
		int count = 0;
		for (int k = 0; k < A.length; k++) {
			if(A[k] == candidate) {
				count++;
				leaderIndex = k;
			}
		}
		
		if (count <= A.length/2) {
			leaderIndex = -1;
		}
		
		return leaderIndex;
	}
}
