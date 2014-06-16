package com.Codility.Massimo;

import java.util.Arrays;

/*
A non-empty zero-indexed array A consisting of N integers is given.
A permutation is a sequence containing each element from 1 to N once, and only once.
For example, array A such that:
    A[0] = 4
    A[1] = 1
    A[2] = 3
    A[3] = 2
is a permutation, but array A such that:
    A[0] = 4
    A[1] = 1
    A[2] = 3
is not a permutation.
The goal is to check whether array A is a permutation.

Write a function:

int solution(int A[], int N);

that, given a zero-indexed array A, returns 1 if array A is a permutation and 0 if it is not.
For example, given array A such that:
    A[0] = 4
    A[1] = 1
    A[2] = 3
    A[3] = 2
the function should return 1.
Given array A such that:
    A[0] = 4
    A[1] = 1
    A[2] = 3
the function should return 0.
Assume that:
N is an integer within the range [1..100,000];
each element of array A is an integer within the range [1..1,000,000,000].
Complexity:
expected worst-case time complexity is O(N);
expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
Elements of input arrays can be modified.
*/

public class PermCheck {

    public int solution(int[] A) {
        // write your code in Java SE 7
    	int N = A.length;
    	int[] count = new int[N];
    	Arrays.fill(count, 0);

    	int j;
    	for (j=0;j<N;j++)
    	{
    		System.out.format("count[%d]: %d\n", j, count[j]);
    	}
    	
    	//memset(count, 0, sizeof(count));
    	
    	//for (i = 0; i < N; i ++)
    	//{
    	//	count[i] = 0 );
    	//
    	//}

    	int i;
    	for (i = 0; i < N; i ++)
    	{
    		System.out.format("A[%d]: %d\n", i, A[i]);
    		if(A[i] > N)
    		{
    			System.out.println("returning 0");
    			return 0;
    		}
    		if( count[A[i]-1] == 0 )
    		{
    			System.out.format("old count[%d]: %d\n", i, count[A[i]-1]);
    			count[A[i]-1] = 1;
    			System.out.format("new count[%d]: %d\n", i, count[A[i]-1]);
    		}
    		else
    		{
    			System.out.println("returning 0");
    			return 0;
    		}
    	}
    	System.out.println("returning 1");
    	return 1;
    }
}