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

class DynamicQueue<TValue> {
    private Node<TValue> _head;
    private Node<TValue> _tail;
    private int _count;

    public DynamicQueue() {
        _head = null;
        _tail = null;
        _count = 0;
    }

    public DynamicQueue(TValue value) {
        _head = new Node<TValue>(value);
        _tail = _head;
        _count = 1;
    }

    public void enqueue(TValue value) {
        Node<TValue> node = new Node<TValue>(value);

        if (_count == 0) {
            _head = node;
            _tail = node;
            _count++;
            return;
        }

        _tail.setNext(node);
        _tail = node;
        _count++;
    }

    public TValue dequeue() {
        if (this.size() == 0) {
            return null;
        }
        TValue value = _head.getValue();
        _head = _head.getNext();
        _count--;

        return value;
    }

    public int size() {
        return _count;
    }

    public TValue peek() {
        if (this.size() == 0) {
            return null;
        }
        return _head.getValue();
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }
}

public class DynamicQueueDemo {
    public static void main(String[] args) {
        DynamicQueue<Integer> intQueue = new DynamicQueue<Integer>();
        assert intQueue != null : "DynamicQueue cannot be null!";

        System.out.println("-----------------------------------------------------------------");
        System.out.println("TEST Enqueue/Dequeue: ");
        System.out.println("Enqueue: intQueue.enqueue(1)");
        intQueue.enqueue(1);
        System.out.println("Enqueue: intQueue.enqueue(2)");
        intQueue.enqueue(2);
        System.out.println("Enqueue: intQueue.enqueue(3)");
        intQueue.enqueue(3);

        System.out.println(String.format("Dequeue: intQueue.dequeue() = %s (should be == 1 )", intQueue.dequeue()));
        System.out.println(String.format("Dequeue: intQueue.dequeue() = %s (should be == 2 )", intQueue.dequeue()));
        System.out.println(String.format("Dequeue: intQueue.dequeue() = %s (should be == 3 )", intQueue.dequeue()));
        System.out.println("-----------------------------------------------------------------");

        System.out.println("TEST size: ");
        System.out.println(String.format("Size: intQueue.size() = %s (should be == 3 )", intQueue.size()));
        System.out.println(String.format("Size: new Queue<int>.size() = %s (should be == 0 )",
                new DynamicQueue<Integer>().size()));

        DynamicQueue<Integer> anotherQueue = new DynamicQueue<Integer>();
        anotherQueue.enqueue(1);
        System.out
                .println(String.format("Size: new Queue<int>(); queue.enqueue(1); queue.size() = %s (should be == 1 )",
                        anotherQueue.size()));
        System.out.println("-----------------------------------------------------------------");

        System.out.println("TEST peek: ");
        System.out.println(String.format("Size: intQueue.peek() = %s (should be == null )", intQueue.peek()));
        System.out.println(String.format("Size: new Queue<int>(100).peek() = %s (should be == 100 )",
                new DynamicQueue<Integer>(100).peek()));
        System.out.println("-----------------------------------------------------------------");

        System.out.println("TEST isEmpty: ");
        System.out.println(String.format("Size: intQueue.isEmpty() = %s (should be == true )", intQueue.isEmpty()));
        System.out.println(String.format("Size: new Queue<int>(100).isEmpty() = %s (should be == false )",
                new DynamicQueue<Integer>(100).isEmpty()));
    }
}
