package com.Codility.Massimo;

import java.util.Stack;

public class Sigma2012 {
	
	public int solution(int[] H) {
        // write your code in Java SE 7
		
		int[] stack = new int[H.length];
		int stack_num = 0;
		int stones = 0;
		for (int i : H) {
			while (stack_num > 0 && stack[stack_num - 1] > i) {
				stack_num -= 1;
			}
			if (!(stack_num > 0 && stack[stack_num - 1] == i)) {
				stack[stack_num] = i;
				stones++;
				stack_num++;
			}
		}
		return stones;
		
/*		Stack<Integer> stack = new Stack<Integer>();
		int blocks = 0;
		int level;
		
		for (int i:H){
			if (i>level){
				stack.push(new Integer(level));
				blocks++;
				level = i;
			}
			if (ii){
				stack.pop();
			}
			level = i;
			if (stack.peek() != level){
				stack.push(new Integer(level));
				blocks++;
			}
		}
		return blocks;*/
    }
	
	
}

