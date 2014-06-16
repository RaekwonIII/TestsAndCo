package com.Codility.Massimo;

import java.util.ArrayList;

public class Peaks {
	public int solution(int[] A) {
        // write your code in Java SE 7
        
		int N = A.length;

	    // Find all the peaks
	    ArrayList<Integer> peaks = new ArrayList<Integer>();
	    for(int i = 1; i < N-1; i++){
	      if(A[i] > A[i-1] && A[i] > A[i+1]) peaks.add(i);
	    }

	    for(int size = 1; size <= N; size++){
	      if(N % size != 0) continue; // skip if non-divisible
	      int find = 0;
	      int groups = N/size;
	      boolean ok = true;
	      // Find whether every group has a peak
	      for(int peakIdx : peaks){
	        if(peakIdx/size > find){
	          ok = false;
	          break;
	        }
	        if(peakIdx/size == find) find++;
	      }
	      if(find != groups) ok = false;
	      if(ok) return groups;
	    }
	    return 0;
    }
}
