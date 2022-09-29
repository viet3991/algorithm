/**
 * Generic version of the Stack class
 *
 * @param <T> the type of the value
 */
class MyStack<T> {
    /**
     * Head node contains front node in the stack
     */
    Node<T> head;

    /**
     * Default constructor
     */
    public MyStack() {
        head = null;
    }

    /**
     * Checking if this stack is empty
     *
     * @return true if stack is empty
     */
    public boolean isEmpty() {
        return (head == null);
    }


    /**
     * Clear the stack
     */
    public void clear() {
        head = null;
    }


    /**
     * Adding new node to the stack
     *
     * @param item     The item to be inserted
     */
    public void push(T item) {
        head = new Node<>(item, head);
    }


}
