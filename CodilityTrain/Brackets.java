package com.Codility.Massimo;

import java.util.LinkedList;

public class Brackets {

	public int solution(String S) {
        // write your code in Java SE 7
		
		LinkedList<Character> stack = new LinkedList<Character>();
		
		for(int i=0;i<S.length();i++) {
			
			char c = S.charAt(i);
			
			
			if(c == '{' || c == '[' || c == '(') {
				stack.push(c);
				} else {
					if(stack.isEmpty()) {
						return 0;
						}
					
					char corresponding = stack.pop();
					
					if(c == ')' && corresponding != '(') {
						return 0;
						}
					
					if(c == ']' && corresponding != '[') {
						return 0;
						}
				
					if(c == '}' && corresponding != '{') {
						return 0;
						}
					
				}
			}
		
		return stack.isEmpty() ? 1 : 0;
    }
}
