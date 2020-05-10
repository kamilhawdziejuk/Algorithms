package alg.DataStructures;


public class DoubleListNode<AnyType> {

    AnyType data;
    DoubleListNode<AnyType> next;
    DoubleListNode<AnyType> prev;
    
    public DoubleListNode(AnyType data) {
        this(null, data, null);
    }

    DoubleListNode(DoubleListNode<AnyType> prev, AnyType data, DoubleListNode<AnyType> next) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

}