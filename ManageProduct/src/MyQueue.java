/**
 * Generic version of the Queue class.
 *
 * @param <T> the type of the value
 */
class MyQueue<T> {

    /**
     * Head node contains front node in the queue
     */
    Node<T> head;

    /**
     * Tail node contains last node in the queue
     */
    Node<T> tail;

    /**
     * Checking if the queue is empty
     * @return
     */
    public boolean isEmpty() {
        return (head == null);
    }

    /**
     * Clear the queue
     */
    public void clear() {
        head = tail = null;
    }

    /**
     * Default constructor
     */
    public MyQueue() {
        head = tail = null;
    }

    /**
     * Adding new node to the queue
     *
     * @param item     The item to be inserted
     */
    public void enqueue(T item) {
        Node newNode = new Node(item);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }
    }



}
