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
