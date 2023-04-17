package ej10;

import java.io.Console;
import java.util.Iterator;

import TDACola.Queue;
import TDAPila.Stack;
import ej4.PilaConEnlaces;
import ej6.QueueLinked;
import exception.EmptyQueueException;

public class AutomataReconocedor {
	private Stack<Character> inverso;
	private Queue<Character> c1,c2;
	
	public AutomataReconocedor() {
		inverso = new PilaConEnlaces<Character>();
		c1 = new QueueLinked<Character>();
		c2 = new QueueLinked<Character>();
	}
	
	//Preguntar si puedo usar el catch para determinar si no pertenece al lenguaje
	//Reconocer es O(n^2)
	
	/**
	 * Reconoce las cadenas que pertenecen al lenguaje {A1xA'1x ... xAnxA'n | n>0, A es de la forma  C z CC, con C perteneciente a {a,b}*}
	 * @param Cadena que se quiera reconocer
	 * @return Si cadena pertenece al lenguaje 
	 */
	public boolean reconocer(String cadena) {
		boolean flag = true;
		String parteString[] = cadena.split("x");
		
		if(parteString.length % 2 == 1) {
			flag = false;
		}

		
		for (int i = 0; i < parteString.length && flag; i++) {
			if(i % 2 == 0) {
				flag = reconocerDoble(parteString[i]);
			}
			else {
				flag = reconocerInverso(parteString[i]);
				vaciar();
			}
			
		}
		return flag;
	}
	
	private boolean reconocerInverso(String cadena) {
		boolean flag = true;
		if(cadena.length() == inverso.size()) {
			for (int i = 0; i < cadena.length() && flag; i++) {
				if(inverso.pop() != cadena.charAt(i)) flag = false;
			}
		}
		else flag = false;
		return flag;
	}
	
	private boolean reconocerDoble(String cadena) {
		boolean flag = true;
		char estado = 'a';
		//recorro la cadena
		for (int i = 0; i < cadena.length(); i++) {
			inverso.push(cadena.charAt(i));
			
			if(cadena.charAt(i) == 'z') {
				estado = 'b';
			}
			if(c1.isEmpty() && estado =='b') {
				estado = 'c';
			}
			if(cadena.charAt(i)!= 'z' ) {
				try {
					switch (estado) {
						case 'a': {
							c1.enqueue(cadena.charAt(i));
							c2.enqueue(cadena.charAt(i));
							break;
						}
						case 'b':{
							if(c1.dequeue() != cadena.charAt(i)) flag = false;
							break;
						}
						case 'c' :{
							if(c2.dequeue() != cadena.charAt(i)) flag = false;
							break;
						}
					}
				}catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
		return flag;
	}
	
	private void vaciar(){
		while (!inverso.isEmpty()) {
			inverso.pop();
		}
		while(!c1.isEmpty()) {
			try {
				c1.dequeue();
			} catch (EmptyQueueException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		while(!c2.isEmpty()) {
			try {
				c2.dequeue();
			} catch (EmptyQueueException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
