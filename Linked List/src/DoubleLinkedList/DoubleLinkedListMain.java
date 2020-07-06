package DoubleLinkedList;

public class DoubleLinkedListMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoubleLinkedList list = new DoubleLinkedList();
		list.createDoubleLinkedList(1);
		list.insertIntoDoubleLinkedList(2, 2);
		list.insertIntoDoubleLinkedList(3, 3);
		list.insertIntoDoubleLinkedList(4, 4);
		list.insertIntoDoubleLinkedList(5, 5);
		list.insertIntoDoubleLinkedList(6, 6);
		list.insertIntoDoubleLinkedList(7, 7);
		list.insertIntoDoubleLinkedList(4, 10);
		list.traverseDoubleLinkedList();
		list.printSize();
		list.reverseTraverseDoubleLinkedList();
		list.searchDoubleLinkedList(4);
		System.out.println("Before Deletion ");
		list.traverseDoubleLinkedList();
		list.printSize();
		list.deletionOfNode(4);
		System.out.println("After Deletion ");
		list.traverseDoubleLinkedList();
		list.printSize();
		System.out.println("Delete Entire List ");
		list.deleteEntireDoubleLinkedList();
		list.traverseDoubleLinkedList();
	}

}