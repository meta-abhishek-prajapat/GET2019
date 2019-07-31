package com.metacube.ques1and2;

import org.junit.Assert;
import org.junit.Test;

public class TestCase {

	@Test
	public void RotateListPositive() {
		LinkedList list = new LinkedList(new Integer[] { 2, 3, 4, 5, 6, 7 });
		list.RotateSubList(2, 5, 2);
		LinkedList expected = new LinkedList(new Integer[] { 2, 5, 6, 3, 4, 7 });
		Node traverseList1 = list.start;
		Node traverseList2 = expected.start;
		while (traverseList1 != null && traverseList2 != null) {
			Assert.assertEquals(traverseList1.data, traverseList2.data);
			traverseList1 = traverseList1.next;
			traverseList2 = traverseList2.next;
		}
	}

	@Test
	public void RotateListNegative() {
		LinkedList list = new LinkedList(new Integer[] { 2, 3, 4, 5, 6, 7 });
		list.RotateSubList(1, 6, 1);
		LinkedList expected = new LinkedList(new Integer[] { 2, 5, 6, 3, 4, 7 });
		Node traverseList1 = list.start;
		Node traverseList2 = expected.start;
		while (traverseList1 != null && traverseList2 != null) {
			Assert.assertNotEquals(traverseList1.data, traverseList2.data);
			traverseList1 = traverseList1.next;
			traverseList2 = traverseList2.next;
		}
	}

	@Test
	public void DetectLoopPositive() {
		LinkedList list = new LinkedList(new Integer[] { 2, 3, 4, 5, 6, 7 });
		Node traverse = list.start;
		while (traverse.next != null)
			traverse = traverse.next;
		traverse.next = list.start;
		Assert.assertTrue(list.DetectLoop());
	}

	@Test
	public void DetectLoopNegative() {
		LinkedList list = new LinkedList(new Integer[] { 2, 3, 4, 5, 6, 7 });
		Assert.assertFalse(list.DetectLoop());
	}
}
