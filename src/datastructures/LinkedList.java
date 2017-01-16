package datastructures;

public class LinkedList<T> {

    private class Node<T> {
        public T data;
        public Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public void add(T data) {
        Node<T> newNode = new Node<T>(data);
        if (head == null) {
            head = newNode;
            tail = head;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }
        size++;
    }

    public void addAtIndex(T data, int idx) {
        Node<T> newNode = new Node<T>(data);

        if (idx == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<T> cur = head;

            while (idx > 1) {
                cur = cur.next;
                idx--;
            }

            newNode.next = cur.next;
            cur.next = newNode;
        }
    }

    public T removeAtIndex(int idx) {
        Node<T> cur = head;

        while (idx > 0) {
            cur = cur.next;
            idx--;
        }

        T data = cur.data;

        cur.data = cur.next.data;
        cur.next = cur.next.next;

        size--;

        return data;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');

        Node<T> cur = head;
        while (cur != null) {
            sb.append(cur.data);
            sb.append(", ");
            cur = cur.next;
        }

        sb.append(']');
        return sb.toString();
    }

}
