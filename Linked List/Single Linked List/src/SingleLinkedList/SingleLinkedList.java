package SingleLinkedList;

import Node.SingleNode;

public class SingleLinkedList {
	
	private SingleNode head;
	private SingleNode tail;
	private int size;
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	// Create a Linked List
	public SingleNode createSingleLinkedList(int nodeValue) {
		head = new SingleNode();
		SingleNode node = new SingleNode();
		node.setValue(nodeValue);
		node.setNext(null);
		head = node;
		tail = node;
		size = 1;
		return head;
	}
	
	// Check whether a Linked List exists
	public boolean existsLinkedList() {
		// return true if head is not null
		return head != null;
	}
	
	// Print Size
	public void printSize() {
		System.out.println("Size "+getSize());
	}
	
	// Insert into a Linked List
	public void insertInLinkedList(int nodeValue, int location) {
		SingleNode node = new SingleNode();
		node.setValue(nodeValue);
		if(!existsLinkedList()) {
			System.out.println("Linked List does not exists ");
		}
		else if (location == 0) { // Insert at First Position
			node.setNext(head);
			head = node;
		}
		else if (location > size) { // Insert at Last Position
			node.setNext(null);
			tail.setNext(node);
			tail = node;
		}
		else { // Insert at a specific location
			SingleNode currentNode = head; // Use head reference
			/*
			if using location starting from 1, following code works fine
			int index = 1;
			while (index < location - 1) {// loop till we reach specified node
				tempNode = tempNode.getNext();
				index++;
			}//tempNode currently references to node after which we should insert new node
			SingleNode nextNode = tempNode.getNext(); //this is the immediate next node after new node
			tempNode.setNext(node);//update reference of tempNode to reference to new node
			node.setNext(nextNode);//update newly added nodes' next. 
			*/
			SingleNode prevNode = null; // Stores the prev node reference
			int index = 0;
			while(index < location -1) { // Iterate before the last node
				prevNode = currentNode;
				currentNode = currentNode.getNext(); // Assign reference of the node where insertion needs to be done
				index++;
			}
			prevNode.setNext(node); // Update reference of tempNode to newly created node
			node.setNext(currentNode); // Update reference of newly created node to the next node
		}
		setSize(getSize()+1); // Update size of Linked List
	}
	
	// Traverse a Linked List
	public void traverseLinkedList() {
		if(existsLinkedList()) {
			SingleNode tempNode = head;
			int index = 0;
			while(index < getSize()) {
				System.out.print(tempNode.getValue()+ " ");
				System.out.print(" -> ");
				tempNode = tempNode.getNext();
				index++;
			}
		}
		else {
			System.out.println("Linked List does not exists ");
		}
		System.out.println("\n");
	}
	
	// Search a Linked List
	public boolean searchLinkedList(int nodeValue) {
		if(existsLinkedList()) {
			SingleNode tempNode = head;
			for(int i = 0; i < getSize(); i++) {
				if(tempNode.getValue() == nodeValue) {
					System.out.println("Found at location "+(i+1));
					return true;
				}
				tempNode = tempNode.getNext();
			}
		}
		System.out.println("List does not exists");
		return false;
	}
	
	// Deletion of Node
	public void deletionOfNode(int location) {
		if(!existsLinkedList()) {
			System.out.println("Linked List does not exist ");
			return; 
		}
		else if(location == 1) { // Delete First Element
			if(size == 1) {
				head = null;
				tail = null;
				setSize(getSize()-1);
				
			}
			if(size > 1) {
				head = head.getNext();
				setSize(getSize()-1);
			}
		}
		else if(location >= size) { // Delete Last Element
			if(size == 1) {
				head = null;
				tail = null;
				setSize(getSize()-1);
			}
			if(size > 1) {
				SingleNode tempNode = head;
				for(int i=0; i<size-2; i++) { // Iterating till second last node
					tempNode = tempNode.getNext();					
				}
				tempNode.setNext(null);
				tail = tempNode;
				setSize(getSize()-1);
			}
		}
		else { // Delete Middle Element
			SingleNode tempNode = head;
			for(int i=0; i<location-2; i++) { // Accessing node before location
				tempNode = tempNode.getNext();
			}
			tempNode.setNext(tempNode.getNext().getNext());
			setSize(getSize()-1);
		}
	}
	
	// Delete Entire Linked List
	public void deleteEntireLinkedList() {
		head = null;
		tail = null;
	}
	
}