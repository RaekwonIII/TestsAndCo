package com.Massimo.MyTest.Test;

import static org.junit.Assert.*;

import org.junit.Test;

public class Test1Test {

	@Test
	public void test() {
		Test1 t1 = new Test1();
		
		String s1 = "see you at the pub";
		String s2 = "see you at the pub";
		assertEquals(0, t1.stringDiff(s1, s2));
		
		s1 = "see you at the pub";
		s2 = "sea you at the pub";
		assertEquals(1, t1.stringDiff(s1, s2));
		
		s1 = "see you at the pub";
		s2 = "sea lou at the pub";
		assertEquals(2, t1.stringDiff(s1, s2));
		
		s1 = "see you at the pub";
		s2 = "sea lou an the pub";
		assertEquals(3, t1.stringDiff(s1, s2));
		
		s1 = "see you at the pub";
		s2 = "sea lou an the pud";
		assertEquals(4, t1.stringDiff(s1, s2));
		
		s1 = "see you at the pub";
		s2 = s1.toUpperCase();
		assertEquals(s1.length()-4, t1.stringDiff(s1, s2));
	}

}
