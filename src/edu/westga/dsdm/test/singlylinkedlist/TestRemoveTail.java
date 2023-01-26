package edu.westga.dsdm.test.singlylinkedlist;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import edu.westga.dsdm.model.SinglyLinkedList;

class TestRemoveTail {

	@Test
	void testNoSuchElementException() {
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		assertThrows(NoSuchElementException.class, () -> list.removeTail());
	}

	@Test
	void testRemoveFromSingleElementList() {
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		list.addTail("A");

		list.removeTail();

		assertAll(() -> assertEquals(0, list.size()));
	}

	@Test
	void testRemoveFromTwoElementList() {
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		list.addTail("A");
		list.addTail("B");

		list.removeTail();

		assertAll(() -> assertEquals(1, list.size()), () -> assertEquals("A", list.getHead()));
	}

	@Test
	void testRemoveFromMultipleElementList() {
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		list.addTail("A");
		list.addTail("B");
		list.addTail("C");

		list.removeTail();

		Iterator<String> iterator = list.new ForwardIterator();
		assertAll(() -> assertEquals(2, list.size()), () -> assertEquals("A", iterator.next()),
				() -> assertEquals("B", iterator.next()));
	}
	
	@Test
	void testRemoveSeveralElements() {
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		list.addTail("A");
		list.addTail("B");
		list.addTail("C");
		list.addTail("D");

		list.removeTail();
		list.removeTail();

		Iterator<String> iterator = list.new ForwardIterator();
		assertAll(() -> assertEquals(2, list.size()), () -> assertEquals("A", iterator.next()),
				() -> assertEquals("B", iterator.next()));
	}

	@Test
	void testRemoveAllElements() {
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		list.addTail("A");
		list.addTail("B");
		list.addTail("C");
		list.addTail("D");
		
		while (!list.isEmpty()) {
			list.removeTail();
		}

		assertAll(() -> assertEquals(0, list.size()));
	}
}
