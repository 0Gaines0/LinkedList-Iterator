package edu.westga.dsdm.test.singlylinkedlist;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

import edu.westga.dsdm.model.SinglyLinkedList;

class TestAddHead {

	@Test
	void testAddOneElement() {
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		list.addHead("A");
		assertAll(() -> assertEquals(1, list.size()), () -> assertEquals("A", list.getHead()));
	}

	@Test
	void testAddTwoElements() {
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		list.addHead("A");
		list.addHead("B");
		assertAll(() -> assertEquals(2, list.size()), () -> assertEquals("B", list.getHead()),
				() -> assertEquals("A", list.getTail()));
	}

	@Test
	void testAddMultipleElements() {
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		list.addHead("A");
		list.addHead("B");
		list.addHead("C");
		Iterator<String> iterator = list.new ForwardIterator();
		assertAll(() -> assertEquals(3, list.size()), () -> assertEquals("C", iterator.next()),
				() -> assertEquals("B", iterator.next()), () -> assertEquals("A", iterator.next()));
	}
}
