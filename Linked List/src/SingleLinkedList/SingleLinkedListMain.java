package SingleLinkedList;

public class SingleLinkedListMain {

	public static void main(String[] args) {
		
		SingleLinkedList singleLinkedList = new SingleLinkedList();
		singleLinkedList.createSingleLinkedList(1);
		singleLinkedList.insertInLinkedList(2, 2);
		singleLinkedList.insertInLinkedList(3, 3);
		singleLinkedList.insertInLinkedList(5, 5);
		singleLinkedList.insertInLinkedList(6, 6);
		singleLinkedList.insertInLinkedList(4, 4);
		System.out.println("After Insertion ");
		singleLinkedList.traverseLinkedList();
		System.out.println("After Search ");
		singleLinkedList.searchLinkedList(6);
		singleLinkedList.deletionOfNode(6);
		System.out.println("After Deletion ");
		singleLinkedList.traverseLinkedList();
		singleLinkedList.printSize();
	}

}
