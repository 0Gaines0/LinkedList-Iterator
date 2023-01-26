package edu.westga.dsdm.test.singlylinkedlist;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

import edu.westga.dsdm.model.SinglyLinkedList;

class TestAddTail {

	@Test
	void testAddOneElement() {
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		list.addTail("A");
		assertAll(() -> assertEquals(1, list.size()), () -> assertEquals("A", list.getTail()));
	}

	@Test
	void testAddTwoElements() {
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		list.addTail("A");
		list.addTail("B");
		assertAll(() -> assertEquals(2, list.size()), () -> assertEquals("A", list.getHead()),
				() -> assertEquals("B", list.getTail()));
	}

	@Test
	void testAddMultipleElements() {
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		list.addTail("A");
		list.addTail("B");
		list.addTail("C");
		Iterator<String> iterator = list.new ForwardIterator();
		assertAll(() -> assertEquals(3, list.size()), () -> assertEquals("A", iterator.next()),
				() -> assertEquals("B", iterator.next()), () -> assertEquals("C", iterator.next()));
	}
}
