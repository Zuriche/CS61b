package project1a;

public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst, nextLast;
    private static final int RFACTOR = 2;
    private static final double MIN_USAGE_RATIO = 0.3;


    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 4;
        nextLast = 5;
    }

    /* Resize array to capacity */
    private void resize(int capacity) {
        T[] newArray = (T[]) new Object[capacity];

        int current = plusOne(nextFirst);
        for (int i = 0; i < size; i++) {
            newArray[i] = items[current];
            current = plusOne(current);
        }

        items = newArray;
        nextFirst = items.length - 1;
        nextLast = size;
    }

    /* Returns the position before the given index in the circular array */
    private int minusOne(int index) {
        if (index - 1 < 0) {
            return items.length - 1;
        }

        return index - 1;
    }

    /* Returns the position after the given index in the circular array */
    private int plusOne(int index) {

        if (index + 1 > items.length - 1) {
            return 0;
        }

        return index + 1;
    }

    /* Adds an item to the nextFirst of the Deque. */
    public void addFirst(T item) {
        if (size == items.length) {
            resize(RFACTOR * size);
        }

        items[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
        size++;
    }

    /* Adds an item to the back of the Deque. */
    public void addLast(T item) {
        if (size == items.length) {
            resize(RFACTOR * size);
        }

        items[nextLast] = item;
        nextLast = plusOne(nextLast);
        size++;
    }

    /* Return true if deque is empty, false otherwise. */
    public boolean isEmpty() {
        return size == 0;
    }

    /* Return number of items in the deque. */
    public int size() {
        return size;
    }

    /* Print the items in the Deque from first to nextLast, separated by a space. */
    public void printDeque() {
        int i = plusOne(nextFirst);

        while (i != nextLast) {
            System.out.print(items[i] + " ");
            i = plusOne(i);
        }
    }

    /* Remove and return the item at the nextFirst of the Deque. If no such item exists,
       returns null. */
    public T removeFirst() {
        if (size == 0) {
            return null;
        }

        int currentFirst = plusOne(nextFirst);
        T removed = items[currentFirst];
        items[currentFirst] = null;
        nextFirst = currentFirst;
        size--;

        if (items.length >= 16 && size < (int) items.length * MIN_USAGE_RATIO) {
            resize(items.length / 2);
        }

        return removed;
    }

    /* Remove and return the item at the back of the Deque. If no such item exists,
       returns null. */
    public T removeLast() {
        if (size == 0) {
            return null;
        }

        int currentLast = minusOne(nextLast);
        T removed = items[currentLast];
        items[currentLast] = null;
        nextLast = currentLast;
        size--;

        if (items.length >= 16 && size < (int) items.length * MIN_USAGE_RATIO) {
            resize(items.length / 2);
        }

        return removed;
    }

    /* Get the item of the given index. If no such item exists, returns null. */
    public T get(int index) {
        if (index >= size || index < 0) {
            return null;
        }

        int current = plusOne(nextFirst);
        for (int i = 0; i < index; i++) {
            current = plusOne(current);
        }

        return items[current];
    }


}
