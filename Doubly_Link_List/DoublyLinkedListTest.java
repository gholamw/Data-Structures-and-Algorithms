package Doubly_Link_List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 * Test class for Doubly Linked List
 *
 * @author
 * @version 12/10/15 20:43:36
 */
@RunWith(JUnit4.class)
public class DoublyLinkedListTest {
	// ~ Constructor ........................................................
	@Test
	public void testConstructor() {
		new DoublyLinkedList<Integer>();
	}

	// ~ Public Methods ........................................................

	// ----------------------------------------------------------
	/**
	 * // * Check if the insertBefore works //
	 */
	 @Test
	 public void testInsertBefore()
	 {
	 // test non-empty list
	 DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
	 testDLL.insertBefore(0,1);
	 testDLL.insertBefore(1,2);
	 testDLL.insertBefore(2,3);
	 testDLL.insertBefore(0,4);
	 assertEquals(
	 "Checking insertBefore to a list containing 3 elements at position 0",
	 "4,1,2,3", testDLL.toString() );
	 System.out.println("test" + testDLL.toString());
	 testDLL.insertBefore(1,5);
	 System.out.println("test" + testDLL.toString());
	 assertEquals(
	 "Checking insertBefore to a list containing 4 elements at position 1",
	 "4,5,1,2,3", testDLL.toString() );
	 testDLL.insertBefore(2,6);
	 assertEquals(
	 "Checking insertBefore to a list containing 5 elements at position 2",
	 "4,5,6,1,2,3", testDLL.toString() );
	 testDLL.insertBefore(-1,7);
	 assertEquals(
	 "Checking insertBefore to a list containing 6 elements at position -1 - expected the element at the head of the list",
	 "7,4,5,6,1,2,3", testDLL.toString() );
	 testDLL.insertBefore(7,8);
	 assertEquals(
	 "Checking insertBefore to a list containing 7 elemenets at position 8 - expected the element at the tail of the list",
	 "7,4,5,6,1,2,3,8", testDLL.toString() );
	 testDLL.insertBefore(700,9);
	 assertEquals(
	 "Checking insertBefore to a list containing 8 elements at position 700 - expected the element at the tail of the list",
	 "7,4,5,6,1,2,3,8,9", testDLL.toString() );
	
	 // test empty list
	 testDLL = new DoublyLinkedList<Integer>();
	 testDLL.insertBefore(0,1);
	 assertEquals(
	 "Checking insertBefore to an empty list at position 0 - expected the element at the head of the list",
	 "1", testDLL.toString() );
	 testDLL = new DoublyLinkedList<Integer>();
	 testDLL.insertBefore(10,1);
	 assertEquals(
	 "Checking insertBefore to an empty list at position 10 - expected the element at the head of the list",
	 "1", testDLL.toString() );
	 testDLL = new DoublyLinkedList<Integer>();
	 testDLL.insertBefore(-10,1);
	 assertEquals(
	 "Checking insertBefore to an empty list at position -10 - expected the element at the head of the list",
	 "1", testDLL.toString() );
	 }
	

	@Test
	public void pop() {
		DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
		testDLL.push(10);
		testDLL.push(4);
		testDLL.push(6);
		testDLL.push(2);
		testDLL.push(9);
		testDLL.pop();
		System.out.println(testDLL.toString());
		assertEquals(
				"Checking insertBefore to an empty list at position -10 - "
						+ "expected the element at the head of the list",
				"10,4,6,2", testDLL.toString());
	}

	@Test
	public void isEmptyTrue() {
		DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
		boolean check = testDLL.isEmpty();
		assertTrue(check);
	}

	@Test
	public void isEmptyFalse() {
		DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
		testDLL.push(10);
		boolean check = testDLL.isEmpty();
		assertFalse(check);
	}

	@Test
	public void push() {
		DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
		testDLL.push(10);
		testDLL.push(4);
		testDLL.push(6);
		testDLL.push(2);
		testDLL.push(9);
		System.out.println(testDLL.toString());
		assertEquals(
				"Checking insertBefore to an empty list at position -10 - "
						+ "expected the element at the head of the list",
				"10,4,6,2,9", testDLL.toString());
		// assertEquals("", null,testDLL.get(-3));
		// assertNull(item);

	}

	@Test
	public void enqueue() {
		DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
		testDLL.enqueue(10);
		testDLL.enqueue(4);
		testDLL.enqueue(6);
		testDLL.enqueue(2);
		testDLL.enqueue(9);
		System.out.println("Enqueue is " + testDLL.toString());
		assertEquals(
				"Checking insertBefore to an empty list at position -10 - "
						+ "expected the element at the head of the list",
				"9,2,6,4,10", testDLL.toString());
	}

	@Test
	public void popToEmpty() {
		DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
		testDLL.push(10);
		testDLL.push(4);
		testDLL.push(6);
		testDLL.push(2);
		testDLL.push(9);
		testDLL.pop();
		testDLL.pop();
		testDLL.pop();
		testDLL.pop();
		testDLL.pop();
		System.out.println("DLL is " + testDLL.toString());

		assertEquals(
				"Checking insertBefore to an empty list at position -10 - "
						+ "expected the element at the head of the list", "",
				testDLL.toString());
	}

	@Test
	public void dequeue() {
		DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
		testDLL.enqueue(10);
		testDLL.enqueue(4);
		testDLL.enqueue(6);
		testDLL.enqueue(2);
		testDLL.enqueue(9);
		testDLL.dequeue();
		testDLL.dequeue();
		testDLL.dequeue();
		testDLL.dequeue();
		System.out.println(testDLL.toString());

		assertEquals(
				"Checking insertBefore to an empty list at position -10 - "
						+ "expected the element at the head of the list", "9",
				testDLL.toString());

	}

	@Test
	public void dequeueToEmpty() {
		DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
		testDLL.enqueue(10);
		testDLL.enqueue(4);
		testDLL.enqueue(6);
		testDLL.enqueue(2);
		testDLL.enqueue(9);
		testDLL.dequeue();
		testDLL.dequeue();
		testDLL.dequeue();
		testDLL.dequeue();
		testDLL.dequeue();
		System.out.println("Dequeue is " + testDLL.toString());
		assertEquals(
				"Checking insertBefore to an empty list at position -10 - "
						+ "expected the element at the head of the list", "",
				testDLL.toString());

	}

	@Test
	public void get() {
		DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
		testDLL.push(10);
		testDLL.push(4);
		testDLL.push(1);
		testDLL.push(7);
		testDLL.push(5);
		int num = testDLL.get(0);
		assertEquals(
				"Checking insertBefore to an empty list at position -10 - "
						+ "expected the element at the head of the list",
				testDLL.get(0).toString(), "10");

	}

	@Test
	public void getNegative() {
		DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
		testDLL.push(10);
		testDLL.push(4);
		testDLL.push(1);
		testDLL.push(7);
		testDLL.push(5);
		assertEquals("", null, testDLL.get(-3));

	}

	@Test
	public void getEmpty() {
		DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
		assertEquals("", null, testDLL.get(4));

	}

}

// TODO: add more tests here. Each line of code in DoublyLinkedList.java should
// be executed at least once from at least one test.

