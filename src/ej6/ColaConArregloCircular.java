package ej6;
import TDACola.Queue;
import exception.EmptyQueueException;
import exception.FullQueueException;

public class ColaConArregloCircular<E> implements Queue<E>{
	
	protected E[] datos;
	protected  int f, r,tamanio;
	public ColaConArregloCircular(int max){
		datos = (E[]) new Object[max];
		f=r=0;
		
	}
	public int size() {
		return (datos.length-f+r)%datos.length;
	}
	
	public boolean isEmpty() {
		return f==r;
	}

	public E front() throws EmptyQueueException {
		if(isEmpty()) throw new EmptyQueueException("Cola vacio");
		
		return datos[f];
	}

	//O(n)
	public void enqueue(E element) /*throws FullQueueException*/{
		if(size() == datos.length) /*throw new FullQueueException("Pila llena");*/
			
		//Preguntas si hago esto o creo una exception
//			E[] aux = (E[]) new Object[datos.length*2];
//			
//			for (int i = 0; i < datos.length; i++) {
//				aux[i]=datos[i];
//			}
		
		datos[r] = element;
		r = (r+1) % datos.length;
	}
		
	public E dequeue() throws EmptyQueueException {
		E temp=null;
		
		if(isEmpty()) throw new EmptyQueueException("Cola vacia");
		
		temp=datos[f];
		datos[f]=null;
		f = (f+1) % datos.length;
		return temp;	
	}

}
