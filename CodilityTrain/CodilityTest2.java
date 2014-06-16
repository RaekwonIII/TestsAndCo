package com.Codility.Massimo;

public class CodilityTest2 {
	
	public int solution(int[][] A) {
// write your code in Java SE 7
        
        int rows = A.length;
		int coloumns = A[0].length;
		
		// Starting point: each element is a country by itself
		int result = rows * coloumns;
		
		// Then check if each element has a neighbor.
		// If so, then the number of countries is decreased.
		// Only look forward, because we count only new 
		// found country members. (don't count members twice)
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < coloumns; j++) {
				
				// overflow check and row neighbor check
				if (i != rows-1 && A[i+1][j] == A[i][j]) {
					result--;
				}
				
				// overflow check and coloumn neighbor check
				if (j != coloumns-1 && A[i][j+1] == A[i][j]) {
					result--;
				}
			}
		}
		
		return result;
    }
	
}
