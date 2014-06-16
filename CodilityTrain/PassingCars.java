package com.Codility.Massimo;

public class PassingCars {
    public int solution(int[] A) {
        // write your code in Java SE 7
        
        int rightSum = 0;
        for(int i = A.length-1; i >= 0; i--)
        {
        	rightSum += A[i];
        	if(A[i] == 0)
        	{
        		A[i] = rightSum;
        	}
        	else
        	{
        		A[i] = 0;
        	}
        }
        
        int count = 0;
        for(int i = 0; i < A.length; i++)
        {
        	count += A[i];
        	
        	if(count > 1000000000)
        	{
        		return -1;
        	}
        }
        
        return count;
    }
}
