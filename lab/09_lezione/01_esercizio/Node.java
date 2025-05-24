class Node<TValue> {
    private TValue value; // the generic value
    private Node<TValue> next; // the pointer to the next value

    /**
     * Will initialize the node with only the current value.
     * 
     * @param value the current value to set
     */
    public Node(TValue value) {
        this.value = value;
        this.next = null;
    }

    /**
     * Will initialize an instance of the node setting the next node.
     * 
     * @param value The current value
     * @param next  The next node to point.
     */
    public Node(TValue value, Node<TValue> next) {
        this.value = value;
        this.next = next;
    }

    /**
     * Will get the current value saved for the node.
     * 
     * @return The current value saved.
     */
    public TValue getValue() {
        return this.value;
    }

    /**
     * Returns the next element of the node.
     * 
     * @return The next elemento of the node.
     */
    public Node<TValue> getNext() {
        return this.next;
    }

    /**
     * Will set the next node of a given value.
     * 
     * @param next The next node
     */
    public void setNext(Node<TValue> next) {
        this.next = next;
    }

    /**
     * Will allocate and set the next node according to a given value.
     * 
     * @param value The given value.
     */
    public void allocateNext(TValue value) {
        Node<TValue> next = new Node<TValue>(value);
        this.setNext(next);
    }
}