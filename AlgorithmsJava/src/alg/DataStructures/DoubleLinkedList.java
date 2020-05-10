package alg.DataStructures;

public class DoubleLinkedList<AnyType> {
    // Front / head node

    private DoubleListNode<AnyType> front;

    // Helper, keeping track of size.

    private int size;

    /**

     * Constructing empty list.

     */

    public DoubleLinkedList() {

        front = null;

        size = 0;

    }

    public void addFront(AnyType x) {
        if (isEmpty())
            front = new DoubleListNode<AnyType>(x);
        else {
        	DoubleListNode temp = front;
            front = new DoubleListNode(null, x, temp);
            front.next.prev = front;
        }
        size++;
    }
    
    /*

    public void addEnd(AnyType x) {

    }

    public void addBefore(AnyType x, AnyType y) {

    }

    public void addAfter(AnyType x, AnyType y) {

    }*/

    public void remove(DoubleListNode<AnyType> current) {


        if (current.next != null)
        {
            current.next.prev = current.prev;	        	
        }
        if (current.prev != null) {
	        current.prev.next = current.next;	
        }
        size--;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

}
