package com.Codility.Massimo;

public class TapeEquilibrium {

	public int solution(int A[]) {

		int totalSum = 0;
	    int i;
	    
	    for (i=0; i<A.length; i++)
	    {
	        totalSum += A[i];
	    }
	    System.out.println(totalSum);
	    
	    int leftSum = 0;
	    int rightSum;
	    int minDiff = totalSum;
	    int difference;
	    
	    int j;
	    for (j=0; j<A.length; j++)
	    {
	    	rightSum = totalSum - leftSum - A[j];
	        leftSum += A[j];
	        difference = Math.abs(leftSum - rightSum);
	        
	        System.out.println(rightSum);
	        System.out.println(leftSum);
	        System.out.println(difference);
	        
	        if (difference < minDiff)
	        {
	            minDiff = difference;
	        }
	    }
	    
	    return minDiff;
	}
}


