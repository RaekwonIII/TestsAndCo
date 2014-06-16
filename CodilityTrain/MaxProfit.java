package com.Codility.Massimo;

public class MaxProfit {
	public int solution(int[] A) {
        // write your code in Java SE 7
		
		int days = A.length;
		if (days < 2)
			return 0;
		
		int maxPriceFromDayX = A[days-1];
		int maxProfit = 0;
		
		for (int i = A.length - 2; i > -1; i--) {
			//max_price_from_here-A[index] means the maximum
	        // profit from current day to end.
			maxProfit = Math.max(maxProfit,	maxPriceFromDayX - A[i]);
			maxPriceFromDayX = Math.max(A[i], maxPriceFromDayX);
		}
		
		return maxProfit;
    }
}
