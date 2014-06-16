package com.Codility.Massimo;

public class MaxCounters {

    public int[] solution(int N, int[] A) {
        // write your code in Java SE 7
    	final int condition = N + 1;
    	
        int[] counters = new int[N];
    	int currentMax = 0;
    	int lastUpdate = 0;
    	for (int i = 0; i < A.length; i++)
    	{
    		if( A[i] == condition)
    		{
    			lastUpdate = currentMax;
    		}
    		else
    		{
    			int position = A[i] - 1;
    			
    			if (counters[position] < lastUpdate)
    			{
    				counters[position] = lastUpdate + 1;
    			}
    			else
    			{
    				counters[position]++;
    			}
    			
    			if (currentMax < counters[position])
    				currentMax = counters[position];
    		}
       	}
    	
    	for(int j = 0; j < counters.length; j++)
    	{
    		if (counters[j] < lastUpdate)
    		{
    			counters[j] = lastUpdate;
    		}
    	}
    	return counters;
    }
}
