package CircularDoubleLinkedList;

import Node.DoubleNode;

public class CircularDoubleLinkedList {
	
	private DoubleNode head;
	
	private DoubleNode tail;
	
	private int size;

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	// Create a Circular Double Linked List
	public DoubleNode createCircularDoubleLinkedList(int nodeValue) {
		DoubleNode node = new DoubleNode();
		node.setValue(nodeValue);
		head = node;
		tail = node;
		node.setNext(node);
		node.setPrev(node);
		setSize(getSize()+1);
		return head;
	}
	
	// Check whether a Linked List exists or not
	public boolean existsLinkedList() {
		return head != null;
	}
	
	// Print Size
	public void printSize() {
		System.out.println("Size "+getSize());
	}
	
	// Insert into Circular Double Linked List
	public void insertIntoCircularDoubleLinkedList(int location, int nodeValue) {
		DoubleNode node = new DoubleNode();
		node.setValue(nodeValue);
		if(!existsLinkedList()) { // If Linked List does not exists
			System.out.println("Double Linked List does not exists ");
			return;
		}
		else if(location == 0 || location == 1) { // Check if Node location is First
			node.setNext(head); // Set next of new node
			node.setPrev(tail); // Set prev of new node
			tail.setNext(node); // Set next of last node to new node
			head.setPrev(node); // Set prev of first node to new node
			head = node; // Set head to new node
		}
		else if(location >= getSize()) { // Check if Node location is last
			node.setNext(head); // Set next of new node
			node.setPrev(tail); // Set prev of new node
			tail.setNext(node); // Set next of last node to new node 
			head.setPrev(node); // Set prev of first node to new node
			tail = node; // Set tail to new node
		}
		else { // Check if Node location is in between Nodes
			DoubleNode tempNode = head;
			int i = 0;
			while(i<location-2) {
				tempNode = tempNode.getNext();
				i++;
			}
			node.setNext(tempNode.getNext()); // Set next of new node
			node.setPrev(tempNode); // Set prev of new node
			tempNode.setNext(node); // Set node before inserted node's next to node
			node.getNext().setPrev(node); // Set node after inserted node's prev to node
		}
		setSize(getSize()+1);
	}
	
	// Traverse Circular Double Linked List
	public void traverseCircularDoubleLinkedList() {
		if(existsLinkedList()) {
			DoubleNode tempNode = head;
			int i = 0;
			while(i < getSize()) {
				System.out.println(tempNode.getValue());
				tempNode = tempNode.getNext();
				i++;
			}
		}
		else {
			System.out.println("Double Linked List does not exists ");
		}
	}
	
	// Reverse Traverse a Circular Double Linked List
	public void reverseTraverseCircularDoubleLinkedList() {
		if(existsLinkedList()) {
			DoubleNode tempNode = tail;
			int i = 0;
			while(i < getSize()) {
				System.out.println(tempNode.getValue());
				tempNode = tempNode.getPrev();
				i++;
			}
		}
		else {
			System.out.println("Double Linked List does not exists ");
		}
	}
	
	// Searching a Circular Double Linked List
	public boolean searchCircularDoubleLinkedList(int nodeValue) {
		if(existsLinkedList()) {
			DoubleNode tempNode = head;
			int i = 0;
			while(i < getSize()) {
				if(nodeValue == tempNode.getValue()) {
					System.out.println("Found at location "+(i+1));
					return true;
				}
				tempNode = tempNode.getNext();
				i++;
			}
			return false;
		}
		else {
			System.out.println("Double Linked List does not exists ");
			return false;
		}
	}
	
	// Deletion of Node in Circular Double Linked List
	public void deletionOfNode(int location) {
		if(!existsLinkedList()) {
			System.out.println("Double Linked List does not exists ");
			return;
		}
		else if(location == 0 || location == 1) { // Check if Node location is First
			if(getSize() == 1) { // Check if Size of list is 1
				head.setNext(null);
				head.setPrev(null);
				head = null;
				tail = null;
			}
			else {
				// head.getNext().setPrev(tail);
				// tail.setNext(head.getNext());
				// head = head.getNext();
				// In a simpler way, can be written as
				head = head.getNext();
				head.setPrev(tail);
				tail.setNext(head);
			}
		}
		else if(location >= getSize()) { // Check if Node location is Last
			if(getSize() == 1) { // Check if Size of list is 1
				head.setNext(null);
				head.setPrev(null);
				head = null;
				tail = null;
			}
			else {
				tail = tail.getPrev();
				tail.setNext(head);
				head.setPrev(tail);
			}
		}
		else { // Check if Node location is in between two nodes
			DoubleNode tempNode = head;
			int i = 0;
			while(i < location-2) {
				tempNode = tempNode.getNext();
				i++;
			}
			tempNode.setNext(tempNode.getNext().getNext());
			tempNode.getNext().setPrev(tempNode);
		}
		setSize(getSize()-1);
	}
	
	// Delete entire Circular Double Linked List
	public void deleteEntireCircularDoubleLinkedList() {
		tail.setNext(null); // Deleting prev reference to first node
		DoubleNode tempNode = head;
		int i = 0;
		while(i < getSize()-1) {
			tempNode.setPrev(null); // Deleting all prev references to node
			tempNode = tempNode.getNext();
			i++;
		}
		head = null;
		tail = null;
		setSize(0);
	}
	
}