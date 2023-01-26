package edu.westga.dsdm.model;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * The Class SinglyLinkedList
 * 
 * @author CS3151
 * @version Spring 2023
 * @param <E> type of list elements
 */
public class SinglyLinkedList<E> implements Iterable<E> {
	private Node head;
	private int size;

	/**
	 * Creates a new singly-linked list
	 * 
	 * @pre none
	 * @post size() == 0
	 */
	public SinglyLinkedList() {
		this.head = null;
		this.size = 0;
	}

	
	/**
	 * Gets the element at the head of this list
	 * 
	 * @pre none
	 * @post none
	 * @return the element at the head of this list
	 * @throws NoSuchElementException if this list is empty
	 */
	public E getHead() {
		if (this.size() <= 0) {
			throw new NoSuchElementException();
		}
		return this.head.value;
	}
	
	/**
	 * Gets the element at the tail of this list
	 * 
	 * @pre none
	 * @post none
	 * @return the element at the tail of this list
	 * @throws NoSuchElementException if this list is empty
	 */
	public E getTail() {
		if (this.size <= 0) {
			throw new NoSuchElementException();
		}
		Node node = this.head;
		while (node.next != null) {
			node = node.next;
		}
		return node.value;
	}

	/**
	 * Gets the size.
	 * 
	 * @pre none
	 * @post none
	 * @return the number if elements in this list
	 */
	public int size() {
		return this.size;
	}

	/**
	 * Check if this list is empty.
	 * 
	 * @pre none
	 * @post none
	 * @return true if this list is empty
	 */
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	/**
	 * Adds the specified element at the head of this list
	 * 
	 * @pre none
	 * @post size() == size()@pre + 1 && getHead().equals(element)
	 * @param element the element to be added
	 */
	public void addHead(E element) {
		Node newNode = new Node(element);
		this.size++;
		newNode.next = this.head;
		this.head = newNode;
	}

	/**
	 * Adds the specified element at the tail of this list
	 * 
	 * @pre none
	 * @post size() == size()@pre + 1 && getTail().equals(element)
	 * @param element the element to be added
	 */
	public void addTail(E element) {
		Node newNode = new Node(element);
		this.size++;
		if (this.head == null) {
			this.head = newNode;
			return;
		}
		Node node = this.head;
		while (node.next != null) {
			node = node.next;
		}
		node.next = newNode;
	}

	/**
	 * Removes the element at the head of this list
	 *
	 * @pre size() > 0
	 * @post size() == size()@pre - 1
	 * @return the removed element
	 * @throws NoSuchElementException if this list is empty
	 */
	public E removeHead() {
		if (this.size() <= 0) {
			throw new NoSuchElementException();
		}
		this.size--;
		E previousHead = this.head.value;
		this.head = this.head.next;
		return previousHead;
	}
	
	/**
	 * removes the element at the tail of this list
	 * 
	 * @pre size() > 0
	 * @post size() == size()@pre - 1
	 * @return the removed element
	 * @throws NoSuchElementException if this list is empty
	 */
	public E removeTail() {
		if (this.size <= 0) {
			throw new NoSuchElementException();
		}
		
		if (this.size == 1) {
			return this.removeHead();
		}
		
		this.size--;
		Node node = this.head;
		while (node.next.next != null) {
			node = node.next;
		}
		E value = node.next.value;
		node.next = null;
		return value;
	}
	
	/**
	 *  reverses linked list 
	 */
	public void reverse() {
		Node pointer = SinglyLinkedList.this.head;
		Node previous = null, current = null;

		while (pointer != null) {
			current = pointer;
			pointer = pointer.next;

			current.next = previous;
			previous = current;
			SinglyLinkedList.this.head = current;
		}
	}
	
	@Override
	public Iterator<E> iterator() {
		return new ForwardIterator();
	}

	private final class Node {
		private E value;
		private Node next;

		private Node(E item) {
			this.value = item;
			this.next = null;
		}
	}

	/**
	 * Class ForwardIterator
	 * 
	 * @author CS3151
	 */
	public class ForwardIterator implements Iterator<E> {
		private Node nextNode;

		/**
		 * Instantiates a new forward iterator
		 */
		public ForwardIterator() {
			this.nextNode = SinglyLinkedList.this.head;
		}

		@Override
		public boolean hasNext() {
			return this.nextNode != null;
		}

		@Override
		public E next() {
			if (!this.hasNext()) {
				throw new NoSuchElementException();
			}
			E element = this.nextNode.value;
			this.nextNode = this.nextNode.next;
			return element;
		}
	}
	
	/**
	 * The Class BackwardIterator.
	 * 
	 * @author Jeffrey Gaines
	 */
	public class BackwardIterator implements Iterator<E> {
		private Node preNode;

		public BackwardIterator() {
			this.preNode = SinglyLinkedList.this.head;
		}

		@Override
		public boolean hasNext() {
			return this.preNode != null;
		}

		@Override
		public E next() {
			if (!this.hasNext()) {
				throw new NoSuchElementException();
			}
			E element = this.preNode.value;
			this.preNode = this.preNode.next;
			return element;
		}

	}

}
