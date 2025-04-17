/**
 * Defines a generic node used by the Set class.
 */
public class SetNode<TValue> {
    private TValue _value;
    private SetNode<TValue> _next;

    /**
     * Initializes a new instance of the node class without a next item.
     * 
     * @param value The given value to set to the initialized node.
     */
    public SetNode(TValue value) {
        _value = value;
        _next = null;
    }

    /**
     * Sets the value to the current node.
     * 
     * @param value The value of the node to set.
     */
    public void setValue(TValue value) {
        _value = value;
    }

    /**
     * Gets the value of the current node.
     * 
     * @return The current value of the node.
     */
    public TValue getValue() {
        return _value;
    }

    /**
     * Sets the next node pointer.
     * 
     * @param next The node pointer to set.
     */
    public void setNext(SetNode<TValue> next) {
        _next = next;
    }

    /**
     * Gets the next pointer
     * 
     * @return The current node's next pointer.
     */
    public SetNode<TValue> getNext() {
        return _next;
    }
}