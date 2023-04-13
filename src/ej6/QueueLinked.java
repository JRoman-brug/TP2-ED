package ej6;

import TDACola.Queue;
import exception.EmptyQueueException;

public class QueueLinked<E> implements Queue<E>{
	protected Nodo<E> head, tail;
	protected int tamanio;
	
	public QueueLinked() {
		head = tail = null;
		tamanio=0;
	}
	
	public int size() {
		return tamanio;
	}

	public boolean isEmpty() {
		return size()==0;
	}

	public E front() throws EmptyQueueException {
		if(isEmpty())throw new EmptyQueueException("Cola vacia");
		return head.getElement();
	}

	public void enqueue(E element){
		Nodo<E> aux =  new Nodo<E>(element);
		if(size()==0) head = aux;
		else tail.setSiguiente(aux);
		
		tail = aux;
		tamanio++;
	}

	public E dequeue() throws EmptyQueueException {
		E aux;
		if(isEmpty())throw new EmptyQueueException("Cola vacia");
	
		aux = head.getElement();
		head = head.getSiguiente();
		tamanio--;
		if(tamanio == 0) tail=null;
		
		return aux;
	}
	
}
