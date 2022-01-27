package CircularSingleLinkedList;

public class CircularSingleLinkedListMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircularSingleLinkedList list = new CircularSingleLinkedList();
		list.createCircularSingleLinkedList(2);
		list.insertInCircularSingleLinkedList(2, 1);
		list.insertInCircularSingleLinkedList(3, 3);
		list.insertInCircularSingleLinkedList(4, 4);
		list.insertInCircularSingleLinkedList(5, 5);
		list.insertInCircularSingleLinkedList(6, 6);
		list.insertInCircularSingleLinkedList(7, 7);
		System.out.println("After Insertion ");
		list.traverseCircularSingleLinkedList();
		System.out.println("After Search ");
		list.searchCircularSingleLinkedList(7);
		System.out.println("Before Deletion ");
		//list.deletionOfNode(0);
		list.deletionOfNode(7);
		list.insertInCircularSingleLinkedList(7, 7);
		System.out.println("After swapping first and last elements in a List ");
		list.swapHeadAndTailNodeValues();
		System.out.println("Sum of all Nodes ");
		list.sumOfAllNodes();
		System.out.println("After Deletion ");
		list.traverseCircularSingleLinkedList();
		System.out.println("Delete Entire List ");
		list.deleteEntireCircularLinkedList();
		list.traverseCircularSingleLinkedList();
	}

}