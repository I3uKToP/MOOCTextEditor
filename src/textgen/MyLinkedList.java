package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
        size = 0;
        head = new LLNode<E>(null);
        tail = new LLNode<E>(null);
        head.next = tail;
        tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 * @return 
	 */
	public boolean add(E element ) 
	{
		
        if (element == null) {
            throw new NullPointerException("Null pointer");
        }
		LLNode <E> n = new LLNode<E> (element);
		n.prev = tail.prev;
		n.next = n.prev.next;
		n.prev.next = n;
		tail.prev = n;
		size ++;
		return false;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		
		if(index<0 || index>=size)

		{
		  throw new IndexOutOfBoundsException("Out Of Bounds");
		}
		LLNode<E> current = new LLNode<E>(null);

		current = head.next;
		for(int i=0; i<index; i++)
		{
		  current=current.next;

		}
		return current.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
        if (element == null) {
            throw new NullPointerException("Null pointer");
        }
        if(index<0 || index>size)

        {
            throw new IndexOutOfBoundsException("Out Of Bounds");
        }
        LLNode<E> current = new LLNode<E>(null);
        current = head;
        for (int i = 0; i <= index; i++) {
            current = current.next;
        }
        //System.out.println(current.data + " текущий элемент");
        LLNode<E> newNode = new LLNode<E>(element);
        newNode.prev = current.prev;
        newNode.next = current;
        current.prev.next = newNode;
        current.prev = newNode;
        size ++;
		

	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		
		/**
	       LLNode<E> current = new LLNode<E>(null);

	        int count = 0;
	        current = head.next;
	        while (current.next != tail.next)
	        {
	            current=current.next;
	            count ++;
	        } */
	        return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		
        if (head == null) {
            throw new NullPointerException("Null pointer");
        }
        if(index<0 || index>size)

        {
            throw new IndexOutOfBoundsException("Out Of Bounds");
        }
        LLNode<E> current = new LLNode<E>(null);
        current = head;
        for (int i = 0; i <= index; i++) {
            current = current.next;
        }
        
        current.prev.next = current.next;
        current.next.prev = current.prev;
        current.prev = null;
        current.next = null;
        size --;
        
		return current.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		
        if (element == null) {
            throw new NullPointerException("Null pointer");
        }
        if(index<0 || index>=size)

        {
            throw new IndexOutOfBoundsException("Out Of Bounds");
        }
        LLNode<E> current = new LLNode<E>(element);
        current = head;
        for (int i = 0; i <= index; i++) {
            current = current.next;
        }
        LLNode<E> newNode = new LLNode<E>(element);
        newNode.prev = current.prev;
        newNode.next = current.next;
        current.prev.next = newNode;
        current.prev = newNode;
        
		return null;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode() 
	{
		this.data = null;
		this.prev = null;
		this.next = null;
	}
	
	public LLNode(E e) 
	{
		this.data = e;

	}
	
	public LLNode(E e, LLNode prevNode) 
	{
		this(e);
	    this.next = prevNode.next;
	    prevNode.next = this;
		

	}

}
