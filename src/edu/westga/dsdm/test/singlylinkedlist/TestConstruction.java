package edu.westga.dsdm.test.singlylinkedlist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.dsdm.model.SinglyLinkedList;

class TestConstruction {

	@Test
	void testStringElemennts() {
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		assertEquals(0, list.size());
	}

	@Test
	void testIntegerElemennts() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
		assertEquals(0, list.size());
	}
}
