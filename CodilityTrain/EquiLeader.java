package com.Codility.Massimo;

public class EquiLeader {
	
	public int solution(int[] A) {
		// write your code in Java SE 7
		int len = A.length;
		int candidate = -1;
		int candidateCount = 0;
		int leader = -1;
		
		//leader candidate
		for (int i = 0; i < len; i++) {
			if (candidateCount ==0) {
				candidate = A[i];
				candidateCount++;
			} else if (A[i] == candidate){
				candidateCount++;
			} else {
				candidateCount--;
			}
		}

		//count candidate occurrences
		int leaderTotCount = 0;
		for(int i : A) {
			if(i == candidate) leaderTotCount++; 
		}
		
		// check if it's a leader?
		if(leaderTotCount <= (len/2)) {
			return 0; // impossible
		} else {
			leader = candidate;
		}
		
		int equiLeaders = 0;
		int leaderCount = 0;
		
		// run the array and count leader occurrences
		for (int i = 0; i < len; i++) {
			if (A[i] == leader) {
				leaderCount++;
			}
			// if we found an index where head and tail have the same leader,
			// this index is an equi leader, increment the count
			if (leaderCount > (i+1)/2 && 
					leaderTotCount - leaderCount > (len - i - 1) /2) {
				equiLeaders++;
			}
		}
		
		return equiLeaders;
	}

}
