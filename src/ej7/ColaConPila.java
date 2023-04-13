package ej7;

import TDACola.Queue;
import ej4.PilaConEnlaces;
import exception.EmptyQueueException;

public class ColaConPila<E> implements Queue<E>{
	protected PilaConEnlaces<E> cola;

	public int size() {
		return cola.size();
	}

	@Override
	public boolean isEmpty() {
		return cola.isEmpty();
	}

	@Override
	public E front() throws EmptyQueueException {
		return cola.top();
	}

	@Override
	public void enqueue(E element) {
		cola.push(element);
	}

	//Pregunta como implementar, si modificar la interfaz para que me de el nodo
	//o popear todos los elementos sacar el primer elemento pusheado
	public E dequeue() throws EmptyQueueException {
		E aux;
		
		
		
		return null;
	}
	

}
