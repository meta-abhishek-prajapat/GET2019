package com.metacube.queue;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircularQueue<Integer> queue = new CircularQueue<Integer>(5);
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		System.out.println(queue.dequeue());
		
		queue.enqueue(5);
		
		
	}

}
