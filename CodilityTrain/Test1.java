package com.Massimo.MyTest.Test;

/*
 * Test 1
 * In this scenario, there are two strings of equal length, however between them
 * there are a number of differences. Compare the two strings and return the
 * number of differences in characters between the two.
 * Example:
 * D23W8MCCIZQOP9
 * D236862CEZQOPS
 * In this case the number of differences between the two strings is 5.
 * Mismatched symbols in this case are coloured red and bold.
 * To summarize: Write a method to compare the number of character-based
 * differences between two given strings. The method should return a single
 * number, denoting the number of differences.
 */
public class Test1 {

	/**
	 * public int stringDiff (String str1, String str2)
	 *
	 * Compares two strings of equal length, checks the i-th character of
	 * each string pairwise, counting the differences. Returns the count
	 *
	 * @param str1 first string to compare
	 * @param str2 second string to compare
	 * @return     the number of different characters between the two strings
	 */
	public int stringDiff (String str1, String str2){

		// check characters pairwise between the two strings
		// takes O(n) time complexity, no faster implementations
		// comes to my mind
		int count = 0;
		for(int i = 0; i < str1.length(); i++){
			if (str1.charAt(i) != str2.charAt(i))
				count++;
		}

		return count;
	}
}
