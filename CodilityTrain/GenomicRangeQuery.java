package com.Codility.Massimo;

public class GenomicRangeQuery {
    public int[] solution(String S, int[] P, int[] Q) {
        // write your code in Java SE 7
    	
    	//used jagged array to hold the prefix sums of each A, C and G genoms
        //we don't need to get prefix sums of T, you will see why.
        int[][] genoms = new int[3][S.length()+1];
        //if the char is found in the index i, we set it to be 1 else they are 0
        // 3 short values are needed for this reason
        short a, c, g;
        for (int i=0; i<S.length(); i++)
        {
            a = 0; c = 0; g = 0;
            if ('A' == (S.charAt(i)))
            {
                a=1;
            }
            if ('C' == (S.charAt(i)))
            {
                c=1;
            }
            if ('G' == (S.charAt(i)))
            {
                g=1;
            }
            //here we calculate prefix sums.
            //for each nucleotide, we have the number of occurrencies at each given position
            genoms[0][i+1] = genoms[0][i] + a;
            genoms[1][i+1] = genoms[1][i] + c;
            genoms[2][i+1] = genoms[2][i] + g;
        }

        int[] result = new int[P.length];
        //here we go through the provided P[] and Q[] arrays as intervals
        for (int i=0; i<P.length; i++) {
        	
            int fromIndex = P[i]+1;
            int toIndex = Q[i]+1;
            
            //check if between Q[i] and P[i] there is at least an A
            if (genoms[0][toIndex] - genoms[0][fromIndex-1] > 0)
            {
                result[i] = 1;
            }
            //check if between Q[i] and P[i] there is at least a C
            else if (genoms[1][toIndex] - genoms[1][fromIndex-1] > 0)
            {
                result[i] = 2;
            }
            //check if between Q[i] and P[i] there is at least a G
            else if (genoms[2][toIndex] - genoms[2][fromIndex-1] > 0)
            {
                result[i] = 3;
            }
            //if there are no A,C,G, then the minimum nucleotide is T
            else
            {
                result[i] = 4;
            }
        }

        return result;
    }
}
