package ej1;

import java.util.EmptyStackException;

import TDAPila.Stack;

public class PilaArreglo<E> implements Stack<E>{
	private E[] datos;
	private int tamanio;
	
	@SuppressWarnings("unchecked")
	public PilaArreglo(int max){
		datos = (E[]) new Object[max];
		tamanio = 0;
	}
	
	public int size() {
		return tamanio;
	}
	
	public boolean isEmpty() {
		return (tamanio==0);
	}
	
	public E top() throws EmptyStackException{
		if(isEmpty()) throw new EmptyStackException();
		return datos[tamanio-1];
	}
	
	public void push(E element) {
		if(element != null) {
			//Si alcanzo el tope, creo otro array con el doble tamaño
			if(tamanio == datos.length) {
				
				E[] aux = (E[]) new Object[datos.length*2];
				
				//Reescribo el array
				for (int i = 0; i < datos.length; i++) {
					aux[i]=datos[i];
				}
				datos = aux;
			}
			
			datos[tamanio] = element;
			tamanio++;
		}
	}
	
	public E pop() throws EmptyStackException{
		E aux;
		if(isEmpty()) throw new EmptyStackException();
		aux = datos[tamanio-1];
		tamanio--;
		
		return aux;
	}
	
	/**
	 * Invierte el contenido de la pila que se pasa por parametro
	 * @param p pila que se invertira
	 */
	public void invertir(Stack<E> P) {

		//invertir es O(n)
		Stack<E> aux1,aux2;
		aux1 = new PilaArreglo<>(P.size());
		aux2 = new PilaArreglo<>(P.size());
		
		transferir(P, aux1);
		transferir(aux1, aux2);
		transferir(aux2, P);
	}
	private void transferir(Stack<E> a, Stack<E> b){
		for (int i = 0; i < datos.length; i++) {
			b.push(a.pop());
		}
	}
	/**
	 * Invierte el contenido de la pila
	 */
	public void invertir() {//O(n)
		E aux;
		for (int i = 0; i < size()/2; i++) {
			aux = datos[i];
			datos[i]=datos[size()-1-i];
			datos[size()-1-i] = aux;
		}
	}
	
	public void invertir(Persona[] A) {//O(3n) => O(n)
		Stack<Persona> pilaPersonas = new PilaArreglo<Persona>(A.length);
		
		for (int i = A.length-1; i>=0 ; i++) {//O(n)
			pilaPersonas.push(A[i]);
		}
		((PilaArreglo<Persona>) pilaPersonas).invertir();//O(n)
		
		for (int i = 0; i < pilaPersonas.size(); i++) {//O(n)
			A[i] = pilaPersonas.pop();
		}
	}
	
	class Persona{
		
	}
}
