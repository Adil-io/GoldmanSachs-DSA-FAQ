package data_structure_implementation;

/**
 * Problem Statement:
 * Implement a double-ended queue (abbreviated to deque) that stores strings.
 * A deque is a data structure that has characteristics of both a queue and a stack.
 * Elements  can be added or removed from either the front or back.
 * Signature:
 * Create Class Deque
 */
public class Deque<T> {

    private class Node {
        T data;
        Node next;
        Node prev;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public Deque() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(T data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(T data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public T removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }
        T data = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        } else {
            head.prev = null;
        }
        size--;
        return data;
    }

    public T removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }
        T data = tail.data;
        tail = tail.prev;
        if (tail == null) {
            head = null;
        } else {
            tail.next = null;
        }
        size--;
        return data;
    }

    public T peekFirst() {
        return isEmpty() ? null : head.data;
    }

    public T peekLast() {
        return isEmpty() ? null : tail.data;
    }

    public void print() {
        Node node = head;
        while (node != null) {
            System.out.print(node.data + (node.next == null ? "" : " -> "));
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Deque<String> deque = new Deque<>();

        deque.addFirst("apple");
        deque.addLast("banana");
        deque.addFirst("cherry");
        System.out.println("Front: " + deque.peekFirst());
        System.out.println("Back: " + deque.peekLast());
        System.out.println("Size: " + deque.size());
        deque.print();

        System.out.println("Removed from front: " + deque.removeFirst());
        System.out.println("Removed from back: " + deque.removeLast());
        System.out.println("Size: " + deque.size());
        deque.print();
    }

}
