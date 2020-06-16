package CircularSingleLinkedList;

import Node.SingleNode;

public class CircularSingleLinkedList {
	
	private SingleNode head;
	private SingleNode tail;
	
	private int size;

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	// Check whether a Linked List exists
	public boolean existsCircularLinkedList() {
		// return true if head != null
		return head != null;
	}
	
	// Print Size
	public void printSize() {
		System.out.println("Size "+getSize());
	}
	
	// Create a Circular Linked List
	public SingleNode createCircularSingleLinkedList(int nodeValue) {
		head = new SingleNode();
		SingleNode node = new SingleNode();
		node.setValue(nodeValue); // Set node value
		node.setNext(node); // Set node reference
		head = node; // Set head reference
		tail = node; // Set tail reference
		size = 1; // Set initial node size while creation
		return head;
	}
	
	// Insert in Circular Single Linked List
	public void insertInCircularSingleLinkedList(int location, int nodeValue) {
		SingleNode node = new SingleNode(); // Create a new node
		node.setValue(nodeValue); // Set new node value
		if(!existsCircularLinkedList()) { // Check whether list exists
			System.out.println("Circular Single Linked List does not exists ");
			return;
		}
		else if(location == 0) { // Check if node location equals 0
			node.setNext(head); // Set newly created node reference to the first node
			head = node; // Set head reference to newly created node
			tail.setNext(node); // Set tail node reference to newly created node
		}
		else if(location > getSize()) {
			node.setNext(head); // Set newly created node reference to the first node
			tail.setNext(node); // Set tail node reference to newly created node
			tail = node; // Set tail reference to newly created reference
		}
		else {
			SingleNode currentNode = head;
			SingleNode prevNode = null;
			for(int i = 0; i < location-1; i++) {
				prevNode = currentNode; // Get prevNode value here
				currentNode = currentNode.getNext(); // Get nextNode value here
			}
			node.setNext(currentNode); // Set the newly inserted node reference to point nextNode
			prevNode.setNext(node); // Set prevNode reference to point the newly created node
		}
		setSize(size+1); // Increment the size by 1 each time
	}
	
	// Traverse Circular Single Linked List
	public void traverseCircularSingleLinkedList() {
		if(existsCircularLinkedList()) {
			SingleNode tempNode = head;
			for(int i = 0; i < getSize(); i++) {
				System.out.println(tempNode.getValue());
				tempNode = tempNode.getNext();
			}
			System.out.println("\n");
		}
		else {
			System.out.println("\nLinked List does not exists !");
		}
	}
	
	// Search a Circular Linked List
	public boolean searchCircularSingleLinkedList(int nodeValue) {
		if(existsCircularLinkedList()) {
			SingleNode tempNode = head;
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
	
	// Deletion of node in a Circular Linked List
	public void deletionOfNode(int location) {
		if(!existsCircularLinkedList()) { // Check whether list exists
			System.out.println("Circular Single Linked List does not exists ");
			return;
		}
		else if(location == 0) { // Check if the node to be deleted is first
			if(getSize() == 1) { // Check if there is only one node in the list
				head = null; // Set head to null
				tail = null; // Set tail to null
				head.setNext(null);  // Set first node to null
			}
			if(getSize() > 1) { // Check if there is more than one node in the list
				head = head.getNext(); // Assign head reference to the next available node in list
				tail.setNext(head); // Set tail node reference to the first node
			}
			setSize(getSize()-1); // Decrease the size of list
		}
		else if(location >= getSize()) {
			if(getSize() == 1) {
				head = null; // Set head to null
				tail = null; // Set tail to null
				tail.setNext(null); // Set tail node reference to null
			}
			if(getSize() > 1) {
				SingleNode tempNode = head;
				for(int i = 0; i < getSize()-2; i++) {
					tempNode = tempNode.getNext();
				}
				tempNode.setNext(head); // Set the node reference to be deleted to head i.e point to the first node 
				tail = tempNode; // Set tail to the last node
			}
			setSize(getSize()-1); // Decrease the size of list
		}
		else { // Delete Middle Element
			SingleNode currentNode = head;
			SingleNode prevNode = null;
			for(int i = 0; i < location-1; i++) {
				prevNode = currentNode; // Get currentNode traversed reference and value
				currentNode = currentNode.getNext(); // Traverse the node from head
			}
			prevNode.setNext(currentNode.getNext()); // Set the previous node reference before the node to be deleted to point the next node
			currentNode.setNext(null); // Set the node reference of the node to be deleted to be null
			setSize(getSize()-1); // Decrease the size of list
		}
	}
	
	// Deletion of entire Circular Linked List
	public void deleteEntireCircularLinkedList() {
		head = null;
		tail.setNext(null);
		tail = null;
	}
	
	// Swapping Head and Tail Node Values
	public void swapHeadAndTailNodeValues() {
		SingleNode tempNode = head;
		// Check until last and first node's references are not the same
		while(tempNode.getNext().getNext() != head) {
			// Get the second last node's reference
			tempNode = tempNode.getNext();
		}
		// Set Last node's reference to the Node after First Node
		tempNode.getNext().setNext(head.getNext());
		// Set Head's reference to the Last Node
		head.setNext(tempNode.getNext());
		// Set Second last node's reference to Head / First Node
		tempNode.setNext(head);
		// Set the head to point the First Node
		head = head.getNext();
	}
	
	// Sum of all Node Values
	public void sumOfAllNodes() {
		SingleNode tempNode = head;
		int sum = tempNode.getValue();
		while(tempNode.getNext() != head) {
			tempNode = tempNode.getNext();
			sum += tempNode.getValue();
		}
		System.out.println("Sum "+sum);
	}

}