package com.metacube.ques1and2;

import java.util.ArrayList;
import java.util.List;

public class LinkedList {

	Node start = null;

	public static void main(String[] args) {
		LinkedList list = new LinkedList(new Integer[] { 2, 3, 4, 5, 6, 7 });
		list.RotateSubList(1, 5, 1);
		list.ShowList();
		Node traverse = list.start;
		while (traverse.next != null)
			traverse = traverse.next;
		traverse.next = list.start;
		System.out.println(list.DetectLoop());

	}
	
	/**
	 * Convert array into linked list
	 * @param list array list
	 */
	public LinkedList(Integer[] list) {
		super();
		for (int loop = 0; loop < list.length; loop++) {
			if(!AddElement(list[loop]))//function which add element into list
				throw new AssertionError();
		}
	}

	/**
	 * Add element into list
	 * @param data which added to list
	 * @return true or false
	 */
	public boolean AddElement(Integer data) {
		if (data == null) {
			return false;
		}
		Node node = new Node(data);
		if (this.start == null) { // if start is null that means list is empty
			start = node;
			return true;
		} else {
			Node lastnode = start;
			while (lastnode.next != null) {
				lastnode = lastnode.next;
			}
			lastnode.next = node;
		}
		return true;
	}

	/**
	 * Show the elements of list
	 */
	public void ShowList() {
		Node node = start;
		while (node != null) {
			System.out.println("data : " + node.data);
			node = node.next;
		}
	}

	/**
	 * Count the number of elements in the list
	 * @param start is the head of the list
	 * @return total no. of elements in the list
	 */
	public Integer countElements(Node start) {
		Node traverse = start;
		Integer count = 0;
		while (traverse != null) {
			count++;
			traverse = traverse.next;
		}
		return count;
	}

	/**
	 * Rotate the list from given range
	 * @param left element number
	 * @param right element number
	 * @param n number of shift
	 */
	public void RotateSubList(Integer left, Integer right, Integer n) {
		Integer totalElements = countElements(this.start);
		if (left < 1 || right > totalElements) {
			throw new AssertionError();
		}
		Integer count = 1;
		Node traverse = this.start;
		Node leftNode = null;
		Node rightNode = null;
		while (traverse != null) {
			if (count == left) {
				leftNode = traverse; //left node address
			}
			if (count == right) {
				rightNode = traverse; //right node address
			}
			count++;
			traverse = traverse.next;
		}

		Rotate(leftNode, rightNode, n); //funtion which rotate the actual list
	}

	/**
	 * Rotate the list
	 * @param left address of node
	 * @param right address of node
	 * @param n number of shift elements
	 */
	public void Rotate(Node left, Node right, Integer n) {
		while (n > 0) {
			Node traverse = left;
			Integer temp = traverse.data;
			Node nextNode = null;
			while (traverse != right) {
				nextNode = traverse.next;
				Integer temp2 = nextNode.data;
				nextNode.data = temp;
				temp = temp2;
				traverse = traverse.next;
			}
			left.data = temp;
			n--;
		}
	}

	/**
	 * Find the loop in linked list
	 * @return if exists then return true else false
	 */
	public Boolean DetectLoop() {
		List<Node> list = new ArrayList<Node>();
		Node traverse = this.start;
		while (traverse != null) {
			if (list.contains(traverse))
				return true;
			list.add(traverse);
			traverse = traverse.next;
		}
		return false;
	}

}
