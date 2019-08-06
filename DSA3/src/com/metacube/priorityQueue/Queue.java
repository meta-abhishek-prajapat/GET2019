package com.metacube.priorityQueue;

public class Queue implements PriorityQueue {
	
	public Task[] tasks;
	public Integer capacity,size;
	
	

	public Queue(Integer capacity) {
		super();
		this.capacity = capacity;
		tasks = new Task[this.capacity];
		this.size = 0;
	}
	
	
	public Task[] getTasks() {
		return tasks;
	}

	@Override
	public boolean isEmpty()
    {
        return size == 0;
    }
    @Override
	public boolean isFull()
    {
        return size == capacity;
    }

	@Override
	public void enqueue(Integer data, Integer priority) {
		 
		if(isFull()){
			throw new AssertionError("Queue is full");
		}
		Task newJob = new Task(data, priority);
		int flag=0;
		for(Integer loop=0;loop<size;loop++){
			System.out.println(tasks[0].priority);
			if(tasks[loop].priority < priority){
				int move = size;
				while(loop<=move){
					tasks[move+1]=tasks[move];
					move--;
				}
				tasks[loop]=newJob;
				size++;
				flag=1;
				break;
			}
			
		}
		if(flag==0){
			tasks[size++]=newJob;
		}
			
	            
	}


	@Override
	public Integer dequeue() {
		if(isEmpty()){
			throw new AssertionError("Queue is Empty");
		}
		Integer move = size;
		Integer data=tasks[0].job;
		for(Integer loop=1;loop<size;loop++){
			tasks[loop-1]=tasks[loop];
				size--;
			}
		return data;
			
	}
		
	@Override
	public Integer peek() {
		if(isEmpty()){
			throw new AssertionError("Queue is Empty");
		}
		Integer data=tasks[0].job;
		return data;
	}

}
