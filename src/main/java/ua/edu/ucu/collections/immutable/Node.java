package ua.edu.ucu.collections.immutable;

public class Node {
    private final Object value;
    private Node next;
    private Node prev;

    public Node getNext() {
        return next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Object getValue() {
        return value;
    }

    public Node(Object value) {
        this.value = value;
    }
}
