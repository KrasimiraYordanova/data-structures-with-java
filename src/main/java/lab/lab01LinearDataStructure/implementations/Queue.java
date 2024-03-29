package lab.lab01LinearDataStructure.implementations;

import interfaces.AbstractQueue;

import java.util.Iterator;

public class Queue<E> implements AbstractQueue<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;
    private static class Node<E> {
        private E element;
        private Node<E> next;
        public Node(E value) {
            this.element = value;
        }
    }
    public Queue() {
        this.head = null;
        this.size = 0;
    }
    @Override
    public void offer(E element) {
        Node<E> newNode = new Node<>(element);
        if (this.head == null) {
            this.head = this.tail = newNode;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;

        }
        this.size++;
    }

    @Override
    public E poll() {
        if(this.isEmpty()) {
            throw new IllegalStateException();
        }

        E element = this.head.element;
        if (this.size == 1) {
            this.head = this.tail = null;
        } else {
            Node<E> next = this.head.next; // new next node = 73(which is the next value after the head)
            this.head.next = null; // the next value after the head (the top value got cut off) = null(because... ->)
            this.head = next; // ...the head = 73(the new top value)
        }
        this.size--;
        return element;
    }

    @Override
    public E peek() {
        if(this.isEmpty()) {
            throw new IllegalStateException();
        }

        return this.head.element;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> current = head;
            @Override
            public boolean hasNext() {
                return this.current != null;
            }

            @Override
            public E next() {
                E element = this.current.element;

                this.current = this.current.next;

                return element;
            }
        };
    }
}
