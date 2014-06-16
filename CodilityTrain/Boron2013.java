package com.Codility.Massimo;

public class Boron2013 {

	public int solution(int[] A) {
        // write your code in Java SE 7
		int N = A.length;
		int[] next = nextPeak(A);
		int i = 1;
		int result = 0;
		while (i * i <= N) {
			int pos = 0;
			int num = 0;
			
			while (pos < N && num < i) {
				pos = next[pos];
				if (pos == -1)
					break;
				num += 1;
				pos += i;
			}
			result = Math.max(result, num);
			i++;
		}
		return result;
    }
	
	
	public boolean[] findPeaks(int[] A) {
		int N = A.length;
		boolean[] peaks = new boolean[N];
		
		for (int i = 1; i < N-1; i++){
			if(A[i] > Math.max(A[i-1], A[i+1])) {
				peaks[i] = true;
			}
		}
		return peaks;
	}
	
	public int[] nextPeak(int[] A){
		int N = A.length;
		
		boolean[] peaks = findPeaks(A);
		int[] next = new int[N];
		next[N-1] = -1;
		
		for (int i = N-2; i > -1; i--) {
			
			if(peaks[i])
				next[i] = i;
			else
				next[i] = next[i+1];
		}

		return next;
	}
}
