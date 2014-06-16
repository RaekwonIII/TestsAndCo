package com.Codility.Massimo;

import java.util.Arrays;

public class Triangle {


	public int solution(int[] A) {

		// write your code in Java SE 7

		if (A.length > 1000000) {
			return 0;
		}

		Arrays.sort(A);

		int p = 0;
		int q = p + 1;
		int r = q + 1;

		// A[p]+A[q]>A[r] && A[q]+A[r]>A[p] &&  A[r]+A[p]>A[q])
		for (;p < A.length - 2; p++, q++, r++) {
			if (A[p] > 0 && A[p] > (A[r] - A[q])) { // R > Q > P !!! -.-'
				return 1;
			}
		}
		return 0;
	}
}

