class Node {
  constructor(element) {
    this.element = element;
    this.next = null;
  }
}

class LinkedList {
  constructor() {
    this.head = null;
    this.size = 0;
  }
  /*  */
  addElement(element) {
    // Create a new Node
    var node = new Node(element);
    var currentNode;
    // Check if the list is empty
    if (this.head == null) {
      this.head = node;
    }
    // If the list is not empty, add element at the last
    else {
      currentNode = this.head;
      while (currentNode.next) {
        currentNode = currentNode.next;
      }
      // Add the node
      currentNode.next = node;
    }
    // Increment the size
    this.size++;
  }

  insertElement(element, index) {
    // Check if index is lesser than 0 or greater than size
    if (index < 0 || index > this.size)
      return console.log("Please enter a valid Index");
    else {
      // Create a new Node
      var node = new Node(element);
      // Create a current and previous Node
      var currentNode, prevNode;
      currentNode = this.head;
      // Check if it's first index
      if (index == 0) {
        node.next = this.head;
        this.head = node;
      }
      else {
        // Iterator variable
        var it = 0;
        
        // Iterate over the list until the given index
        while (it < index) {
          it++;
          prevNode = currentNode;
          currentNode = currentNode.next;
        }
        node.next = currentNode;
        prevNode.next = node;
      }
      // Increment the size
      this.size++;
    }
  }

  removeElement(element) {
      var currentNode, prevNode;
      currentNode = this.head;
      while(currentNode) {
            // Check if the element is found
            if(currentNode.element == element) {
                // Check if it is first node
                if(prevNode == null) {
                  this.head = currentNode.next;
                }
                // Check if it is not first node
                else {
                  prevNode.next = currentNode.next;
                }
                // Decrement the size
                this.size--;
                return prevNode;
            }
            prevNode = currentNode;
            currentNode = currentNode.next;
      }
  }

  // Remove element from a given index
  removeElementFrom(index) {
    // Check if index is lesser than 0 or greater than size
    if (index < 0 || index > this.size) {
      return console.log("Please enter a valid Index");
    } else {
      var currentNode, prevNode;
      currentNode = this.head;
      // Check if it's first index
      if (index == 0) {
        this.head = currentNode.next;
        currentNode.next = null;
      }
      // If it's other index
      else {
        // Iterator variable
        var it = 0;
        // Iterate over the list until the given index
        while (it < index) {
          it++;
          prevNode = currentNode; // 0, 1, 2, 3, 4
          currentNode = currentNode.next; // 1, 2, 3, 4, null
        }
        prevNode.next = currentNode.next;
      }
      // Decrement the size
      this.size--;
    }
  }

  /* Utility Functions */
  isEmpty() {
    return this.size == 0;
  }

  size() {
    console.log(this.size);
    return this.size;
  }

  print() {
    var currentNode = this.head;
    // Iterate the list till the end
    while (currentNode) {
      console.log(currentNode.element);
      currentNode = currentNode.next;
    }
  }
}

let list = new LinkedList();

// Add an element
list.addElement(10);
list.addElement(20);
list.addElement(30);
list.addElement(40);
list.addElement(50);
list.addElement(60);
list.addElement(70);
list.addElement(80);

// Print the contents of List
list.print();

console.log("Inserting element ");

// Insert an element at the given index
list.insertElement(90, 0);

// Print the contents of List
list.print();

console.log("Removing element at given index ");

// Remove element at the given index
list.removeElementFrom(4);

// Print the contents of List
list.print();

console.log("Removing element ");

// Remove element
list.removeElement(30);

// Print the contents of List
list.print();
