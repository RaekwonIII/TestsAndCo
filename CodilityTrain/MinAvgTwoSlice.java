package com.Codility.Massimo;

public class MinAvgTwoSlice {
    public int solution(int[] A) {
        // write your code in Java SE 7
    	
    	long[] prefSum = new long[A.length + 1];

    	for (int i = 1; i < A.length; i++) {
    		prefSum[i] = prefSum[i-1] + A[i-1];
    	}

    	double minAvg = Integer.MAX_VALUE;
    	int result = 0;
    	for(int p = 1; p < A.length-1; p++) {
    		for (int q = p; q < A.length; q++) {
    			double avg = (double) (prefSum[q] - prefSum[p]) / (double)(q-p+1);

    			if(avg < minAvg) {
    				minAvg = avg;
    				result = p;
    			}
    		}
    	}

    	return result;
    }
}
