package com.Codility.Massimo;
/*
 * I took a training challenge on Codility that checks for the proper nesting of brackets in a string. 
 * The brackets to be checked are {,},(,),[,]. 
 * 
 * I have written the following Java program which passes in O(n) time and space, but I have a 
 * feeling that the extra space I use can be reduced. Also I think that there must be a data 
 * structure that can handle this scenario more efficiently. Using an ArrayList instead of an array 
 * might help. What I need here is a critique of my code.
 * 
 */

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

class BracketNestingVerifier {
    public boolean solution(String input) {
    	
    	HashMap<Character, Character> matches = new HashMap<Character, Character>();
        matches.put('{', '}');
        matches.put('(', ')');
        matches.put('[', ']');

        Set<Character> specialChars = new HashSet<Character>();
        Deque<Character> expected = new LinkedList<Character>();
        
        for (Entry<Character, Character> ee : matches.entrySet()) {
            specialChars.add(ee.getKey());
            specialChars.add(ee.getValue());
        }
        /*
         * The loop through the string here is pretty simple and straight-forward:
         * 
         * - Have we waited for this character? If so, remove it from the list of expected 
         *   characters we are waiting for (The "stack")
         *   
         * - If the above is not true, does this character have a matching ending character? If it 
         *   does, add it to the stack
         *   
         * - Again, if the above also is not true, is this character regarded as a special character? 
         *   If it is, then we know here already that we have failed so we can return from the method.
         *   
         */
        for (int i = 0; i < input.length(); i++) {
        	
            char next = input.charAt(i);
            
            Character expect = expected.peekLast();
            
            if (expect != null && expect == next) {
            	
                expected.removeLast();
            }
            else if (matches.containsKey(next)) {
            	
                expected.addLast(matches.get(next));
            }
            else if (specialChars.contains(next)) {
            	
                return false;
            }
        }
        return true;
    }
}
