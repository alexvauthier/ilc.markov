/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cfranc.ilc;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 *
 * @author av395701
 */
public class TestAlexVauthier {
    
	String[] when2SimpleWords = new String[] {"parapluie", "parachute"};
	
	@Test
	public void getSimilarity_2SimpleWords_26() {
		
		MarkovWord m = new MarkovWord();
		double expected = 0.33;
		double actual = m.getSimilarity(when2SimpleWords[0],when2SimpleWords[1], 2);
		assertEquals(expected, actual,0.01);		
	}

	@Test
	public void getSimilarity_SameWord_100() {
		
		MarkovWord m = new MarkovWord();
		double expected = 1.0;
		double actual = m.getSimilarity(when2SimpleWords[0],when2SimpleWords[0], 4);
		assertEquals(expected, actual,0.000000001);		
	}
        
        @Test
	public void common_SameWord_12() {
		
		MarkovWord m = new MarkovWord();
		double expected = 12;
		double actual = m.common(m.processString(when2SimpleWords[0], 4), m.processString(when2SimpleWords[0], 4));
		assertEquals(expected, actual,0.01);		
	}
        
        @Test
	public void common_2SimpleWords_5() {
		
		MarkovWord m = new MarkovWord();
		double expected = 5;
		double actual = m.common(m.processString(when2SimpleWords[0], 2), m.processString(when2SimpleWords[1], 2));
		assertEquals(expected, actual,0.01);		
	}
        
        @Test
	public void union_SameWord_10() {
		
		MarkovWord m = new MarkovWord();
		double expected = 10;
		double actual = m.union(m.processString(when2SimpleWords[0], 2), m.processString(when2SimpleWords[0], 2));
		assertEquals(expected, actual,0.01);		
	}
        
        @Test
	public void union_2SimpleWords_15() {
		
		MarkovWord m = new MarkovWord();
		double expected = 15;
		double actual = m.union(m.processString(when2SimpleWords[0], 2), m.processString(when2SimpleWords[1], 2));
		assertEquals(expected, actual,0.01);		
	}
        
        @Test
	public void processString_SimpleWord_av() {
		
		MarkovWord m = new MarkovWord();
		List<MarkovData> expected = new ArrayList<MarkovData>();
                expected.add(new MarkovData("%a",1));
                expected.add(new MarkovData("av",1));
                expected.add(new MarkovData("v%",1));
		List<MarkovData> actual = m.processString("av", 2);
		assertEquals(expected, actual);
	}
        
        @Test
	public void contains_include_1() {
		
		MarkovWord m = new MarkovWord(when2SimpleWords[0],2);
		int expected = 1;
		int actual = m.contains("pa");
		assertEquals(expected, actual);		
	}
        
        @Test
	public void contains_different_0() {
		
		MarkovWord m = new MarkovWord(when2SimpleWords[0],2);
		int expected = 0;
		int actual = m.contains("ze");
		assertEquals(expected, actual);		
	}
        
        
        
        
}
