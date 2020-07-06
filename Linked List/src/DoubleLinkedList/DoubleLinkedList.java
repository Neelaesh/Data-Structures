package DoubleLinkedList;

import Node.DoubleNode;

public class DoubleLinkedList {
	
	private DoubleNode head;
	
	private DoubleNode tail;
	
	private int size;
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	// Create a Double Linked List
	public DoubleNode createDoubleLinkedList(int nodeValue) {
		DoubleNode node = new DoubleNode();
		node.setValue(nodeValue);
		node.setNext(null);
		node.setPrev(null);
		head = node;
		tail = node;
		size = 1;
		return head;
	}
	
	// Check whether a Linked List exists or not
	public boolean existsLinkedList() {
		return head != null ? true : false;
	}
	
	// Print Size
	public void printSize() {
		System.out.println("Size "+getSize());
	}
	
	// Insert into a Double Linked List
	public void insertIntoDoubleLinkedList(int location, int nodeValue) {
		DoubleNode node = new DoubleNode();
		node.setValue(nodeValue);
		// Check whether a Linked List exists or not
		if(!existsLinkedList()) {
			System.out.println("Double Linked List does not exists ");
			return;
		}
		else if(location == 0 || location == 1) { // If location equals first
			node.setNext(head);
			node.setPrev(null);
			head.setPrev(node);
			head = node;
		}
		else if(location > getSize()) { // If location equals last
			node.setNext(null);
			node.setPrev(tail);
			tail.setNext(node);
			tail = node;
		}
		else { // If location is in between nodes
			DoubleNode tempNode = head;
			int i = 0;
			while(i < location-2) {
				tempNode = tempNode.getNext();
				i++;
			}
			node.setNext(tempNode.getNext());
			node.setPrev(tempNode);
			tempNode.setNext(node);
			node.getNext().setPrev(node);
		}
		setSize(getSize()+1);
	}
	
	// Traverse a Double Linked List
	public void traverseDoubleLinkedList() {
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
	
	// Reverse Traverse a Double Linked List
	public void reverseTraverseDoubleLinkedList() {
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
	
	// Search a Double Linked List
	public boolean searchDoubleLinkedList(int nodeValue) {
		if(existsLinkedList()) {
			DoubleNode tempNode = head;
			for(int i = 0; i < getSize(); i++) {
				if(tempNode.getValue() == nodeValue) {
					System.out.println("Found at location "+(i+1));
					return true;
				}
				tempNode = tempNode.getNext();
			}
		}
		System.out.println("\nLinked List does not exists !");
		return false;
	}
	
	// Deletion of a Node in Double Linked List
	public void deletionOfNode(int location) {
		if(!existsLinkedList()) {
			System.out.println("Double Linked List does not exists ");
			return;
		}
		else if(location == 0 || location == 1) { // If location equals first
			if(getSize() == 1) {
				head = null;
				tail = null;
			}
			else {
				head = head.getNext();
				head.setPrev(null);
			}
		}
		else if(location >= getSize()) { // If location equals last
			if(getSize() == 1) {
				head = null;
				tail = null;
			}
			else {
				tail = tail.getPrev();
				tail.setNext(null);
			}
		}
		else { // If location is in between nodes
			DoubleNode tempNode = head;
			for(int i = 0; i < location-2 ; i++) {
				tempNode = tempNode.getNext();
			}
			tempNode.setNext(tempNode.getNext().getNext()); // Set the next value to the next node after the node to be deleted
			tempNode.getNext().setPrev(tempNode); // Set the prev value to point the node before to the deleted node
		}
		setSize(getSize()-1);
	}
	
	// Delete entire Double Linked List
	public void deleteEntireDoubleLinkedList() {
		DoubleNode tempNode = head;
		int i = 0;
		while(i < getSize()-1) { 
			tempNode.setPrev(null); // Delete prev references of node
			tempNode = tempNode.getNext();
			i++;
		}
		head = null;
		tail = null;
		setSize(0);
	}
	
}