package com.Codility.Massimo;

import java.util.Stack;
/*
 *  A stack machine is a simple system that performs arithmetic operations
 *  on an input string of numbers and operators.
 *  It contains a stack that can store an arbitrary number of 12-bit
 *  unsigned integers. Initially the stack is empty. The machine
 *  processes a string of characters in the following way:
 *  
 *  - the characters of the string are processed one by one;
 *  - if the current character is a digit ('0' - '9'), the machine pushes the
 *    value onto its stack;
 *  - if the current character is '+', the machine pops the two topmost values
 *    from its stack, adds them and pushes the result onto the stack;
 *  - if the current character is '*', the machine pops the two topmost values
 *    from its stack, multiplies them and pushes the result onto the stack;
 *  - after the machine has processed the whole string, it returns the topmost
 *    value of its stack as the result;
 *  - the machine reports an error if any operation it performs (addition or 
 *    multiplication) results in an overflow;
 *  - the machine reports an error if it tries to pop an element from its stack
 *    when the stack is empty, or if the stack is empty after the machine has 
 *    processed the whole string.
 *    
 *    Write a function;
 *    
 *    class Solution { public int solution(String S); }
 *    
 *    that, given a string S consisting of N characters containing input for 
 *    the stack machine, returns the result the machine would return if given 
 *    this string. The function should return -1 if the machine would report 
 *    an error when processing the string.
 *    For example, given string S = "13+62*7+*" the function should return 76.
 *    Given string S = "11++" the function should return -1.
 *    
 *    Assume that:
 *    - the length of S is within the range [0...1000000];
 *    - string S consists only of the following characters: 0...9, +, *
 *    
 *    
 */
public class CodilityTest1 {
	public int solution(String S) {
        // write your code in Java SE 7
		int result = -1;
		Stack<Integer> myStack = new Stack<Integer>();
		
		for (int i = 0; i < S.length(); i++) {
			if(S.charAt(i) == '+') {
				if (myStack.size() < 2) {
					//illegal operation
					return -1;
				} else {
					// pop 2 items, sum, then push
					int a = myStack.pop();
					int b = myStack.pop();
					if (a + b > Integer.MAX_VALUE)
						return -1;
					else 
						myStack.push(a + b);
				}
			} else if (S.charAt(i) == '*'){
				if (myStack.size() < 2) {
					//illegal operation
					return -1;
				} else {
					// pop 2 items, mult, then push
					int a = myStack.pop();
					int b = myStack.pop();
					if (a * b > Integer.MAX_VALUE)
						return -1;
					else 
						myStack.push(a * b);
				}
			} else {
				// simple push
				myStack.push(Character.getNumericValue(S.charAt(i)));
			}
		}
		
		if (!myStack.isEmpty())
			result = myStack.pop();
		
		return result;
    }

}
