package ej6;

public class Nodo<E> {
	private E element;
	private Nodo<E> siguiente;
	
	public Nodo(E item, Nodo<E> sig) {
		element = item;
		siguiente = sig;
	}
	public Nodo(E item) {
		this(item,null);
	}
	
	public E getElement() {
		return element;
	}
	public void setElement(E element) {
		this.element = element;
	}
	public Nodo<E> getSiguiente() {
		return siguiente;
	}
	public void setSiguiente(Nodo<E> siguiente) {
		this.siguiente = siguiente;
	}
}
