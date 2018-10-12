package project1a;

public class LinkedListDeque<T> {
    private class Node<T>{
        private T item;
        private Node prev;
        private Node next;
        public Node(T item) {
            this.item = item;
            this.prev = null;
            this.next = null;
        }
        public Node() {
            item = null;
            prev = null;
            next = null;
        }
        public Node(T item, Node prev, Node next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node sentinel;
    private int size;

    public LinkedListDeque() {
        size = 0;
        sentinel = new Node();
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    public void addFirst(T item) {
        Node node = new Node(item, sentinel, sentinel.next);
        sentinel.next.prev = node;
        sentinel.next = node;

        size ++;


    }

    public void addLast(T item) {
        Node node = new Node(item, sentinel.prev, sentinel);
        sentinel.prev.next = node;
        sentinel.prev = node;
        size ++;

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node curr = sentinel.next;
        while(curr != sentinel ) {
            System.out.println(curr.item + "");
            curr = curr.next;
        }

    }

    public T removeFirst() {
        T remove = (T) sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.next.prev = sentinel;
        size --;
        return remove;

    }

    public T removeLast(){
        T remove = (T) sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.prev.next = sentinel;
        size -- ;
        return remove;

    }

    public T get(int index) {
        if(index >= size || index < 0) {
            return null;

        }
        Node curr = sentinel.next;
        int i = 0;
        while(i < index) {
            curr = curr.next;
            i++;
        }

        return (T) curr.item;

    }

    public T getRecursive(int index) {
        return (T) getRecursiveHelper(index, sentinel.next);
    }
    public T getRecursiveHelper(int index, Node curr) {
        if(index == 0) {
            return (T) curr.item;
        }
        return (T) getRecursiveHelper(index - 1, curr.next);
    }

}
