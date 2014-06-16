package com.Codility.Massimo;

import java.util.Arrays;

public class Beta2010 {
	
	public int solution(int[] A) {
        // write your code in Java SE 7
        int discCount = A.length;
        
        long[] rangeMin = new long[discCount];
        long[] rangeMax = new long[discCount];
        
        for (int index = 0; index < discCount; index++) {
            rangeMin[index] = index - A[index];
            rangeMax[index] = index + A[index];
        }
        
        Arrays.sort(rangeMin);
        Arrays.sort(rangeMax);
        
        int rangeMinIndex = 0;
        long intersect = 0;
        
        //for each disc
        for (int rangeMaxIndex=0; rangeMaxIndex < discCount; rangeMaxIndex++) {
            
            //exclude the discs where curr_disc_center + radius > disc_center - disc_radius
            while (rangeMinIndex < discCount && rangeMax[rangeMaxIndex] >= rangeMin[rangeMinIndex]) {
                
                rangeMinIndex++;
            }
            
            //with this count, the disc intersects with itseld, so -1 to correct
            intersect += rangeMinIndex - rangeMaxIndex -1;
            
            if (intersect > 10000000) {
                return -1;
            }
        }
        
        return (int)intersect;
    }
}
