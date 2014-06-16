package com.Codility.Massimo;
import static org.junit.Assert.*;

import org.junit.Test;


public class BracketNestingVerifierTest {

	@Test
	public void testSolution() {
		BracketNestingVerifier BNV = new BracketNestingVerifier();
		
	    assertTrue(BNV.solution("{,},({,}),[,]"));

	    assertFalse(BNV.solution("{(,},({,}),[,]"));
	    assertFalse(BNV.solution("{,)},({gfdgfd}),[,]"));
	    assertFalse(BNV.solution("{(,}),({,}),[,]"));

	    assertTrue(BNV.solution("{,},(,),[[,]]"));
	    assertTrue(BNV.solution("{,},(,),[,]"));
	    assertTrue(BNV.solution("{{,}},(,),[,]"));
	    assertTrue(BNV.solution("{,},((,)),[,]"));
	    assertTrue(BNV.solution("{,},(,),[,]"));
	    assertTrue(BNV.solution("(), {{{,}}},(,),[,]"));
		//fail("Not yet implemented");
	}

}
