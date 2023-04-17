package ej10;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import TDAPila.Stack;
import ej4.PilaConEnlaces;

public class TestAutomata {
	private AutomataReconocedor at;
	private String cadenaPertence[] = {"bzbbxbbzb","azaaxaaza","abzababxbabazba","bzbbxbbzbxazaaxaaza","aaabzaaabaaabxbaaabaaazbaaaxabzababxbabazba","zxz"};
	private String cadenaNoPertence[] = {"bzbbxbbzbaaa","azaaxaaaaza","abzabbbabxbabazba","bzbbxbaabzbxazaaxaaza","aaabzaaabaaabxbaaabaaazbaaaaaaaxabzababxbaaabazba"};

	private AutomataReconocedor getAutomata(){
		//Pone tu clase aca
	  return new AutomataReconocedor();
	  
	}
	@Before
	public void setUp() {
		at = getAutomata();
	}
	@Test // Reconoce las que pertenecen
	public void pertenece() {
		for (int i = 0; i < cadenaPertence.length; i++) {
			assertTrue("No lo reconoce wacho: ", at.reconocer(cadenaPertence[i]));	
		}
	}
	@Test
	public void noPertenece() {
		for (int i = 0; i < cadenaNoPertence.length; i++) {
			assertFalse("Lo reconoce wacho: ", at.reconocer(cadenaNoPertence[i]));	
		}
	}
}
