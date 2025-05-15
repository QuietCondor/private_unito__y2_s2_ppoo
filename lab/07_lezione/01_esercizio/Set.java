public class Set<TValue> {
    private SetNode<TValue> _first;
    private int _size;

    /**
     * Initializes an empty set.
     */
    public Set() {
        _first = null;
        _size = 0;
    }

    /**
     * Returns the size of the set.
     * 
     * @return The current size of the set.
     */
    public int size() {
        return _size;
    }

    /**
     * Returns whether the set is empty or not
     * 
     * @return TRUE if empty. FALSE otherwise
     */
    public boolean empty() {
        return _size == 0;
    }

    /**
     * Adds a node at the start of the set.
     * 
     * @param item The given value of the set.
     */
    public void add(TValue item) {
        if (this.contains(item)) {
            return;
        }

        SetNode<TValue> itemNode = new SetNode<TValue>(item);
        itemNode.setNext(_first);

        _first = itemNode;
        _size++;
    }

    /**
     * Removes an item from the set.
     * 
     * @param item The given item to search.
     * @return TRUE if found and removed. FALSE otherwise.
     */
    public boolean remove(TValue item) {
        if (_size == 0) {
            return false;
        }

        if (_size == 1 && _first.getValue() != item) {
            return false;
        }

        if (_size == 1) {
            _first = null;
            _size = 0;
            return true;
        }

        SetNode<TValue> prev = _first;
        SetNode<TValue> curr = _first.getNext();

        if (prev.getValue().equals(item)) {
            _first = curr;
            _size--;
            return true;
        }

        while (curr != null && curr.getValue() != item) {
            prev = curr;
            curr = curr.getNext();
        }

        if (curr == null) {
            return false;
        }

        prev.setNext(curr.getNext());
        _size--;
        return true;
    }

    /**
     * Checks whether the set contains an item or not
     * 
     * @param item The given item to look for.
     * @return TRUE, if the set contains the given item. FALSE otherwise.
     */
    public boolean contains(TValue item) {
        if (_size == 0) {
            return false;
        }

        if (_size == 1 && _first.getValue() != item) {
            return false;
        }

        if (_size == 1) {
            return true;
        }

        SetNode<TValue> node = _first;
        while (node != null && node.getValue() != item) {
            node = node.getNext();
        }

        return node != null;
    }

    /**
     * Checks whether a set is a subset of another.
     * 
     * @param right The other set.
     * @return TRUE if this set is subset to right. FALSE otherwise.
     */
    public boolean subsetOf(Set<TValue> right) {
        if (right == null) {
            return false;
        }

        boolean shouldContinue = true;
        for (SetNode<TValue> leftNode = _first; leftNode != null && shouldContinue; leftNode = leftNode.getNext()) {
            shouldContinue = right.contains(leftNode.getValue());
        }

        return shouldContinue;
    }

    /**
     * Checks whether a set is equal of another.
     * 
     * @param right The other set.
     * @return TRUE if equal. FALSE otherwise.
     */
    public boolean equalsTo(Set<TValue> right) {
        if (right == null) {
            return false;
        }

        if (this._size != right.size()) {
            return false;
        }

        boolean shouldContinue = true;
        for (SetNode<TValue> leftNode = _first; leftNode != null && shouldContinue; leftNode = leftNode.getNext()) {
            shouldContinue = right.contains(leftNode.getValue());
        }

        return shouldContinue;
    }

    public Set<TValue> union(Set<TValue> right) {
        if (right == null) {
            return this.union(this);
        }

        Set<TValue> unionSet = new Set<TValue>();
        for (SetNode<TValue> node = _first; node != null; node = node.getNext()) {
            if (!unionSet.contains(node.getValue())) {
                unionSet.add(node.getValue());
            }
        }

        for (SetNode<TValue> node = right._first; node != null; node = node.getNext()) {
            if (!unionSet.contains(node.getValue())) {
                unionSet.add(node.getValue());
            }
        }

        return unionSet;
    }

    public Set<TValue> intersection(Set<TValue> right) {
        if (right == null || right.size() == 0) {
            return new Set<TValue>();
        }

        Set<TValue> intersectSet = new Set<>();

        for (SetNode<TValue> node = _first; node != null; node = node.getNext()) {
            if (!intersectSet.contains(node.getValue()) && right.contains(node.getValue())) {
                intersectSet.add(node.getValue());
            }
        }

        for (SetNode<TValue> node = right._first; node != null; node = node.getNext()) {
            if (!intersectSet.contains(node.getValue()) && this.contains(node.getValue())) {
                intersectSet.add(node.getValue());
            }
        }

        return intersectSet;
    }

    public String print() {
        if (_size == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (SetNode<TValue> node = _first; node != null; node = node.getNext()) {
            if (node.getNext() == null) {
                sb.append(node.getValue());
            } else {
                sb.append(node.getValue() + ", ");
            }
        }

        sb.append("]");
        return sb.toString();
    }

    public String toString() {
        return this.print();
    }
}
