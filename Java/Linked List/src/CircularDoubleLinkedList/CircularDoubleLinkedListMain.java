package CircularDoubleLinkedList;

public class CircularDoubleLinkedListMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircularDoubleLinkedList list = new CircularDoubleLinkedList();
		list.createCircularDoubleLinkedList(1);
		list.insertIntoCircularDoubleLinkedList(1, 2);
		list.insertIntoCircularDoubleLinkedList(3, 3);
		list.insertIntoCircularDoubleLinkedList(5, 5);
		list.insertIntoCircularDoubleLinkedList(6, 6);
		list.insertIntoCircularDoubleLinkedList(4, 4);
		list.traverseCircularDoubleLinkedList();
		list.printSize();
		list.reverseTraverseCircularDoubleLinkedList();
		list.searchCircularDoubleLinkedList(5);
		System.out.println("Before Deletion");
		list.traverseCircularDoubleLinkedList();
		list.deletionOfNode(4);
		System.out.println("After Deletion");
		list.traverseCircularDoubleLinkedList();
		System.out.println("Delete Entire List ");
		list.deleteEntireCircularDoubleLinkedList();
		list.traverseCircularDoubleLinkedList();
	}

}