/**
 * Represents a linked list.
 * Each node of type LinkedListElement
 *  ["header" | next] --> [el | next] --> [el | next] --> [el | next] --> null 
 *            ↑  	                                          ↑	
 *          first                                           last
 */
public class LinkedList
{
	protected LinkedListElement first; // Never changes (pointing to header node)
	protected LinkedListElement last;  // Last node
	
	LinkedList()
	{
		makenull();
	}
	

	/**
	 * Creates and initialises empty linked list.
	 */
	public void makenull()
	{
		// First node is always "header" node
		first = new LinkedListElement("header", null);
		last = null;
	}
	
	//Funkcija addLast doda nov element na konec seznama
	/**
	 * Adds a new element to the end of the list.
	 * @param obj is the new element to be added.
	 */
	public void addLast(Object obj)
	{
		LinkedListElement newEl = new LinkedListElement(obj, null);
		if (last == null) {
			last = first;
			last.next = newEl;
		} 
		else {
			last.next.next = newEl;
			last = last.next;
		}
	}
	
	/**
	 * Print all of the elements of a linked list.
	 */
	public void write()
	{
		// We start at the header and loop through all of the elements
		LinkedListElement el = first.next;
		System.out.print("header -> ");
		while (el != null) {
			System.out.print("[" + el.element+ "]" + " -> ");
			el = el.next;
		}
		System.out.println("null");

		// Additionally Check first and last
		System.out.printf("[first]-> %s\n", first.element);
		System.out.printf("[last]-> %s\n", last != null ? last.element : "none");
	}
	
	/**
	 * Adds a new element to a beginning of a linked list
	 * @param obj new element to be added at the beginning
	 */
	void addFirst(Object obj)
	{
		LinkedListElement newEl = new LinkedListElement(obj, null);
		
		// Connect it to the header node
		newEl.next = first.next;
		first.next = newEl;

		// Check both edge cases
		if (last == null) 
			last = first;
		else if (last == first) 
			last = newEl;
	}
	
	/**
	 * Returns the length of a linked list
	 * @return length of this linked list
	 */
	int length()
	{
		LinkedListElement walker_node = first.next;
		int length = 0;
		while (walker_node != null) {
			length++;
			walker_node = walker_node.next;
		}
		return length;
	}
	
	/**
	 * Returns the lengthf of a linked list calculated recursively
	 * @return length of this linked list
	 */
	int lengthRek()
	{
		return lengthRek(first.next);
	}

	int lengthRek(LinkedListElement el) {
		if (el == null) 
			return 0;
		return 1 + lengthRek(el.next);
	}
	
	/**
	 * Inserts an element at n-th place of a linked list
	 * @param obj element to be inserted
	 * @param n place to be inserted at
	 * @return true if operation was successful, else false
	 */
	boolean insertNth(Object obj, int n)
	{
		LinkedListElement current_node = first;

		for (int i = 0; i < n; i++) {
			current_node = current_node.next;
			if (current_node == null) {
				return false;
			}
		}

		LinkedListElement newEl = new LinkedListElement(obj);
		newEl.next = current_node.next;
		current_node.next = newEl;

		// Edge cases we have to fix last pointer
		if (last == null) {
			last = first;
		}
		else if (last == current_node) {
			last = last.next;
		}
		else if (last.next == current_node) {
			last = current_node;
		}
		return true;

	}
	
	/**
	 * Deletes n-th element of a linked list
	 * @param n index of an element to be deleted
	 * @return true if an element was deleted and false otherwise
	 */
	boolean deleteNth(int n)
	{
		LinkedListElement current_node = first;
		LinkedListElement prev_node = null;

		for (int i = 0; i < n; i++) {
			prev_node = current_node;
			current_node = current_node.next;
			if (current_node == null ) {
				return false;
			}
		}
		if (current_node.next == null) {
			return false;
		}
		else {
			// Edge cases (if we have to fix last pointer)
			if (last == current_node.next) {
				last = current_node;
			}
			else if (last == current_node) {
				last = prev_node;
			}
			current_node.next = current_node.next.next;
			return true;
		}
	}
	
	/**
	 * Reverse order of all elements in a linked list
	 */
	void reverse()
	{
		// If empty list ignore
		if (last == null || last == first) return;

		LinkedListElement current_node = first.next.next;
		first.next.next = null; // tihs will be our new last element
		last = current_node; // fix last pointer 

		while (current_node != null) {
			LinkedListElement temp_node = current_node.next;
			current_node.next = first.next;
			first.next = current_node;
			current_node = temp_node;
		}
	}
	
	/**
	 * Recursive version of reverse()
	 */
	void reverseRek()
	{
		reverseRek(first.next);
	}

	void reverseRek(LinkedListElement el) {
		if (el == null) {
			return;
		} 
		if (el.next == null) {
			first.next = el;
			last = first;
		}
		else {
			reverseRek(el.next);
			el.next = null;
			last = last.next;
			last.next = el;
		}
	}
	
	/**
	 * Remove all duplicate elements of a this linked list
	 */
	void removeDuplicates()
	{
		if (last == null | last == first) return;	

		LinkedListElement current_node = first.next;
		while (current_node != null) {
			LinkedListElement walker_node = current_node;
			while (walker_node.next != null) {
				if (walker_node.next.element.equals(current_node.element)) {
					walker_node.next = walker_node.next.next;
				}
				else {
					walker_node = walker_node.next;
				}
			}
			current_node = current_node.next;
		}

		// Fix last pointer;
		last = null;
		current_node = first;
		while (current_node.next != null) {
			if (current_node.next.next == null) {
				last = current_node;
				return;
			}
			else {
				current_node = current_node.next;
			}
		}
	}
}