package com.metacube.employee;

public class Employee {
	
	public Node sorted = null;
	public Node current = null;
	public Node head = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee emp = new Employee();
		emp.addEmployee(1,101,21);
		emp.addEmployee(2,301,24);
		emp.addEmployee(3,301,22);
		Node ptr = emp.insertionSort(emp.head);
	}
	
	/**
	 * add employee in linked list
	 * @param id type: int
	 * @param salary type: int
	 * @param age type: int
	 * @return head pointer of the list type: node
	 */
	public boolean addEmployee(int id, int salary, int age) {
		Node new_Node = new Node(id, salary, age);	
		if(head == null) {
			head = new_Node;
			return true;
		}
		
		Node last = head; 
		while(last.next != null){
			last = last.next;
		}
		last.next = new_Node;
		return true;
	}
	
	/**
	 * to pick the node and send to insert and sort
	 * @param headref type: Node
	 * @return head of the list
	 */
	Node insertionSort(Node headref)  
	{ 
	    // Initialize sorted linked list 
		sorted = null; 
		current = headref; 
		
		while (current != null)  
		{ 
			Node next = current.next;  
			sortedInsert(current);  
		    current = next; 
		}  
		head = sorted; 
	
		return head;
	} 
		  
	 /** 
	 * function to insert a new_node in a list.
	 * @param newnode : new node which add in list according to its sort
`	 **/
	void sortedInsert(Node newnode) {

		if (sorted == null || sorted.getSalary() <= newnode.getSalary())  
		{ 
		    newnode.next = sorted; 
		    sorted = newnode; 
		} 
		else { 
			current = sorted; 
	        if(current.next.getSalary() > newnode.getSalary()) {
				while (current.next != null && current.next.getSalary() > newnode.getSalary())
		        {
		        	
		            current = current.next; 
		        }
	        }
	        else if((current.next.getSalary() == newnode.getSalary()) && (current.next.getAge() > current.next.getAge())) {
	        	while (current.next != null && (current.next.getSalary() == newnode.getSalary()) && (current.next.getAge() > current.next.getAge())){
	        		current = current.next;
	        	}
	        }
	        
	        newnode.next = current.next; 
	        current.next = newnode; 
	    } 
	} 
	 
}


