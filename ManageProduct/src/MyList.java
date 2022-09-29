/**
 * Generic version of the LinkedList class.
 *
 * @param <T> the type of the value
 */
public class MyList<T> {
    Node<T> head;
    Node<T> tail;

    /**
     * Default constructor
     */
    public MyList() {
        head = tail = null;
    }

    /**
     * Constructor with head and tail
     *
     * @param head Head node of this list
     * @param tail Tail node of this list
     */
    public MyList(Node head, Node tail) {
        this.head = head;
        this.tail = tail;
    }

    /**
     * Checking if this list is empty
     *
     * @return true if list is empty
     */
    public boolean isEmpty() {
        return (head == null);
    }

    /**
     * Clear the list
     */
    public void clear() {
        head = tail = null;
    }


    /**
     * Insert an item to the tail of this list
     *
     * @param item The item to be inserted
     */
    public void insertToTail(T item) {
        Node newNode = new Node(item);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }


}
