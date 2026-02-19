import java.util.ArrayList;
import java.util.List;

public class LinkedListDeque61B<T> implements Deque61B<T>{

    private class Node {
        private T item;
        private Node previous;
        private Node next;

        public Node(T item, Node previous, Node next) {
            this.item = item;
            this.previous = previous;
            this.next = next;
        }
    }

    private Node sentinel;
    private int size;

    public LinkedListDeque61B() {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.previous = sentinel;
        size = 0;
    }

    @Override
    public void addFirst(T x) {
        Node first = new Node(x, sentinel, sentinel.next);
        sentinel.next.previous = first;
        sentinel.next = first;
        size += 1;
    }

    @Override
    public void addLast(T x) {
        Node last = new Node(x, sentinel.previous, sentinel);
        sentinel.previous.next = last;
        sentinel.previous = last;
        size += 1;
    }

    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>();
        Node curr = sentinel.next;
        while(curr != sentinel) {
            returnList.add(curr.item);
            curr = curr.next;
        }
        return returnList;
    }

    @Override
    public boolean isEmpty() {
        return sentinel.next == sentinel;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        return null;
    }

    @Override
    public T removeLast() {
        return null;
    }

    @Override
    public T get(int index) {
        Node curr = sentinel.next;
        if (size < index) {
            return null;
        } else {
            while (index != 0) {
                curr = curr.next;
                index -= 1;
            }
        }
        return curr.item;
    }

    @Override
    public T getRecursive(int index) {
        return getRecursiveHelper(index, sentinel.next);
    }
    private T getRecursiveHelper(int index, Node curr) {
        if (size < index) {
            return null;
        }
        if (index == 0) {
            return curr.item;
        } else {
            return getRecursiveHelper(index - 1, curr.next);
        }
    }
}
