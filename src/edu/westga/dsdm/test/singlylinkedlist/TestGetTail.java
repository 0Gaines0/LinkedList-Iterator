package edu.westga.dsdm.test.singlylinkedlist;

import static org.junit.jupiter.api.Assertions.*;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import edu.westga.dsdm.model.SinglyLinkedList;

class TestGetTail {

	@Test
	void testNoSuchElementException() {
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		assertThrows(NoSuchElementException.class, () -> list.getHead());
	}
	
	@Test
	void testOneElementList() {
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		list.addTail("A");
		
		assertEquals("A", list.getHead());
	}

	@Test
	void testAddMultipleElementList() {
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		list.addTail("A");
		list.addTail("B");
		list.addTail("C");
		
		assertEquals("A", list.getHead());
	}
}
