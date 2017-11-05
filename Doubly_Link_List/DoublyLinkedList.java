package Doubly_Link_List;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

// -------------------------------------------------------------------------
/**
 *  This class contains the methods of Doubly Linked List.
 *
 *  @author  
 *  @version 12/10/15 20:44:01
 */

/**
 * Class DoublyLinkedList: implements a *generic* Doubly Linked List.
 * 
 * @param <T>
 *            This is a type parameter. T is used as a class name in the
 *            definition of this class.
 *
 *            When creating a new DoublyLinkedList, T should be instantiated
 *            with an actual class name that extends the class Comparable. Such
 *            classes include String and Integer.
 *
 *            For example to create a new DoublyLinkedList class containing
 *            String data: DoublyLinkedList<String> myStringList = new
 *            DoublyLinkedList<String>();
 *
 *            The class offers a toString() method which returns a
 *            comma-separated sting of all elements in the data structure.
 * 
 *            This is a bare minimum class you would need to completely
 *            implement. You can add additional methods to support your code.
 *            Each method will need to be tested by your jUnit tests -- for
 *            simplicity in jUnit testing introduce only public methods.
 */
class DoublyLinkedList<T extends Comparable<T>> {

	/**
	 * private class DLLNode: implements a *generic* Doubly Linked List node.
	 */
	private class DLLNode {
		public final T data; // this field should never be updated. It gets its
								// value once from the constructor DLLNode.
		public DLLNode next;
		public DLLNode prev;

		/**
		 * Constructor
		 * 
		 * @param theData
		 *            : data of type T, to be stored in the node
		 * @param prevNode
		 *            : the previous Node in the Doubly Linked List
		 * @param nextNode
		 *            : the next Node in the Doubly Linked List
		 * @return DLLNode
		 */
		public DLLNode(T theData, DLLNode prevNode, DLLNode nextNode) {
			data = theData;
			prev = prevNode;
			next = nextNode;
		}
	}

	// Fields head and tail point to the first and last nodes of the list.
	private DLLNode head, tail;

	/**
	 * Constructor
	 * 
	 * @return DoublyLinkedList
	 */
	public DoublyLinkedList() {
		head = null;
		tail = null;
	}

	/**
	 * Tests if the doubly linked list is empty
	 * 
	 * @return true if list is empty, and false otherwise
	 *
	 *         Worst-case asymptotic runtime cost: TODO
	 *
	 *         Justification: TODO
	 */
	public boolean isEmpty() {
		if (this.head == null) {
			return true;
		}
		return false;
	}

	/**
	 * Inserts an element in the doubly linked list
	 * 
	 * @param pos
	 *            : The integer location at which the new data should be
	 *            inserted in the list. We assume that the first position in the
	 *            list is 0 (zero). If pos is less than 0 then add to the head
	 *            of the list. If pos is greater or equal to the size of the
	 *            list then add the element at the end of the list.
	 * @param data
	 *            : The new data of class T that needs to be added to the list
	 * @return none
	 *
	 *         Worst-case asymptotic runtime cost: TODO
	 *
	 *         Justification: TODO
	 */
	public void insertBefore(int pos, T data) {
		int counter = 0;
		DLLNode temp = new DLLNode(data, null, null);
		DLLNode currentNode = this.head;
		if (isEmpty()) {
			this.head = temp;
			this.tail = temp;
			return;
		}

		if (pos < 0) {
			enqueue(data);
			return;
		}

		while (pos > counter) {
			if (currentNode.next != null) {
				currentNode = currentNode.next;
			} else {
				push(data);
				return;
			}
			counter++;
		}
		
		if(pos == 0){
			enqueue(data);
			return;
		}
		
		temp.next = currentNode;
		temp.prev = currentNode.prev;
		currentNode.prev.next = temp;
		currentNode.prev = temp;

		System.out.println("test" + this.toString());

		return;
	}

	/**
	 * Returns the data stored at a particular position
	 * 
	 * @param pos
	 *            : the position
	 * @return the data at pos, if pos is within the bounds of the list, and
	 *         null otherwise.
	 *
	 *         Worst-case asymptotic runtime cost: TODO
	 *
	 *         Justification: TODO
	 *
	 *         Worst-case precise runtime cost: TODO
	 *
	 *         Justification: TODO
	 */
	public T get(int pos) {
		if (isEmpty() || pos < 0) {
			return null;
		}
		int counter = 0;
		DLLNode temp = this.head;
		while (counter > pos) {
			temp = temp.next;
			counter++;
		}

		T item = temp.data;
		return item;
	}

	/**
	 * Deletes the element of the list at position pos. First element in the
	 * list has position 0. If pos points outside the elements of the list then
	 * no modification happens to the list.
	 * 
	 * @param pos
	 *            : the position to delete in the list.
	 * @return true : on successful deletion, false : list has not been
	 *         modified.
	 *
	 *         Worst-case asymptotic runtime cost: TODO
	 *
	 *         Justification: TODO
	 */
	public boolean deleteAt(int pos) {
		// TODO
		return false;
	}

	/*----------------------- STACK */
	/**
	 * This method should behave like the usual push method of a Stack ADT. If
	 * only the push and pop methods are called the data structure should behave
	 * like a stack. How exactly this will be represented in the Doubly Linked
	 * List is up to the programmer.
	 * 
	 * @param item
	 *            : the item to push on the stack
	 *
	 *            Worst-case asymptotic runtime cost: TODO
	 *
	 *            Justification: TODO
	 */
	public void push(T item) {
		DLLNode temp = new DLLNode(item, null, null);
		if (isEmpty()) {
			this.head = temp;
			this.tail = temp;
		} else {
			this.tail.next = temp;
			temp.prev = this.tail;
			this.tail = temp;
		}
	}

	/**
	 * This method should behave like the usual pop method of a Stack ADT. If
	 * only the push and pop methods are called the data structure should behave
	 * like a stack. How exactly this will be represented in the Doubly Linked
	 * List is up to the programmer.
	 * 
	 * @return the last item inserted with a push; or null when the list is
	 *         empty.
	 *
	 *         Worst-case asymptotic runtime cost: TODO
	 *
	 *         Justification: TODO
	 */
	public T pop() {
		DLLNode temp = this.tail.prev;
		T item = this.tail.data;

		if (this.head.next == null) {
			this.head = null;
			this.tail = null;
			return null;
		}

		this.tail = temp;
		this.tail.next = null;
		return item;
	}

	/*----------------------- QUEUE */

	/**
	 * This method should behave like the usual enqueue method of a Queue ADT.
	 * If only the enqueue and dequeue methods are called the data structure
	 * should behave like a FIFO queue. How exactly this will be represented in
	 * the Doubly Linked List is up to the programmer.
	 * 
	 * @param item
	 *            : the item to be enqueued to the stack
	 *
	 *            Worst-case asymptotic runtime cost: TODO
	 *
	 *            Justification: TODO
	 */
	public void enqueue(T item) {
		DLLNode temp = new DLLNode(item, null, null);
		if (isEmpty()) {
			this.head = temp;
			this.tail = temp;
			return;
		}

		this.head.prev = temp;
		temp.next = this.head;
		this.head = temp;
	}

	/**
	 * This method should behave like the usual dequeue method of a Queue ADT.
	 * If only the enqueue and dequeue methods are called the data structure
	 * should behave like a FIFO queue. How exactly this will be represented in
	 * the Doubly Linked List is up to the programmer.
	 * 
	 * @return the earliest item inserted with a push; or null when the list is
	 *         empty.
	 *
	 *         Worst-case asymptotic runtime cost: TODO
	 *
	 *         Justification: TODO
	 */
	public T dequeue() {
		T item = this.tail.data;
		DLLNode temp = this.tail.prev;

		if (this.head.next == null) {
			this.head = null;
			this.tail = null;
			return null;
		}

		this.tail.prev = null;
		temp.next = null;
		this.tail = temp;
		return item;
	}

	/**
	 * @return a string with the elements of the list as a comma-separated list,
	 *         from beginning to end
	 *
	 *         Worst-case asymptotic runtime cost: Theta(n)
	 *
	 *         Justification: We know from the Java documentation that
	 *         StringBuilder's append() method runs in Theta(1) asymptotic time.
	 *         We assume all other method calls here (e.g., the iterator methods
	 *         above, and the toString method) will execute in Theta(1) time.
	 *         Thus, every one iteration of the for-loop will have cost
	 *         Theta(1). Suppose the doubly-linked list has 'n' elements. The
	 *         for-loop will always iterate over all n elements of the list, and
	 *         therefore the total cost of this method will be n*Theta(1) =
	 *         Theta(n).
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		boolean isFirst = true;

		// iterate over the list, starting from the head
		for (DLLNode iter = head; iter != null; iter = iter.next) {
			if (!isFirst) {
				s.append(",");
			} else {
				isFirst = false;
			}
			s.append(iter.data.toString());
		}

		return s.toString();
	}
	
	public static void main(String[] args){
		 DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
		 testDLL.insertBefore(0,1);
		 testDLL.insertBefore(1,2);
		 testDLL.insertBefore(2,3);
		 testDLL.insertBefore(0,4);
		 testDLL.insertBefore(1,5);
		 System.out.println(testDLL.toString());
		 
	}

}
