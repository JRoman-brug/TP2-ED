package ej1;

import static org.junit.Assert.assertTrue;

public class Main {
	
	public static void main(String[] args) {
		String n1,n2,n3;
		n1 = "Uno";
		n2 = "Dos";
		n3 = "Tres";
		
		PilaArreglo<String> s2 = new PilaArreglo<String>(3);
		
		s2.push(n1);
		s2.push(n2);
		s2.push(n3);
		
		System.out.println(s2.pop());
		System.out.println(s2.pop());
		System.out.println(s2.pop()+"\n");
		
		s2.push(n1);
		s2.push(n2);
		s2.push(n3);
		s2.invertir();

		System.out.println(s2.pop());
		System.out.println(s2.pop());
		System.out.println(s2.pop());
		
		
		
		/*
		 * s2.push(n1);
		s2.push(n2);
		s2.push(n3);
		System.out.println(s2.pop() == n1);
		System.out.println(s2.pop() == n2);
		System.out.println(s2.pop() == n3);
		 */
	}

}
