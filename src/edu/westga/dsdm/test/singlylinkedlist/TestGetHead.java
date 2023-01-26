package edu.westga.dsdm.test.singlylinkedlist;

import static org.junit.jupiter.api.Assertions.*;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import edu.westga.dsdm.model.SinglyLinkedList;

class TestGetHead {

	@Test
	void testNoSuchElementException() {
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		assertThrows(NoSuchElementException.class, () -> list.getTail());
	}
	
	@Test
	void testOneElementList() {
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		list.addTail("A");
		
		assertEquals("A", list.getTail());
	}

	@Test
	void testAddMultipleElementList() {
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		list.addTail("A");
		list.addTail("B");
		list.addTail("C");
		
		assertEquals("C", list.getTail());
	}
}
