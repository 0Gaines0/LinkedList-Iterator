package edu.westga.dsdm.test.singlylinkedlist;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import edu.westga.dsdm.model.SinglyLinkedList;

class TestRemoveHead {

	@Test
	void testNoSuchElementException() {
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		assertThrows(NoSuchElementException.class, () -> list.removeHead());
	}

	@Test
	void testRemoveFromSingleElementList() {
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		list.addTail("A");

		list.removeHead();

		assertAll(() -> assertEquals(0, list.size()));
	}

	@Test
	void testRemoveFromTwoElementList() {
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		list.addTail("A");
		list.addTail("B");

		list.removeHead();

		assertAll(() -> assertEquals(1, list.size()), () -> assertEquals("B", list.getHead()));
	}

	@Test
	void testRemoveFromMultipleElementList() {
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		list.addTail("A");
		list.addTail("B");
		list.addTail("C");

		list.removeHead();

		Iterator<String> iterator = list.new ForwardIterator();
		assertAll(() -> assertEquals(2, list.size()), () -> assertEquals("B", iterator.next()),
				() -> assertEquals("C", iterator.next()));
	}

	@Test
	void testRemoveSeveralElements() {
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		list.addTail("A");
		list.addTail("B");
		list.addTail("C");
		list.addTail("D");

		list.removeHead();
		list.removeHead();

		Iterator<String> iterator = list.new ForwardIterator();
		assertAll(() -> assertEquals(2, list.size()), () -> assertEquals("C", iterator.next()),
				() -> assertEquals("D", iterator.next()));
	}

	@Test
	void testRemoveAllElements() {
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		list.addTail("A");
		list.addTail("B");
		list.addTail("C");
		list.addTail("D");
		
		while (!list.isEmpty()) {
			list.removeHead();
		}

		assertAll(() -> assertEquals(0, list.size()));
	}
}
