package ru.kpfu.itis.group11403.akhmerova.Stack;

/**
 * Created by Adelya on 27.03.2015.
 */
public class Stack<T> {
    class Elem<T> {
        T val;
        Elem<T> next;
    }

    int size = 0;

    private Elem<T> head;

    public Stack() {
        head = null;
    }

    public void add(T x) {
        Elem<T> p = new Elem<T>();
        p.val = x;
        p.next = head;
        head = p;
        size++;
    }

    public T delete() {
        T x = head.val;
        head = head.next;
        size--;
        return x;
    }

    public int size() {
        return size;
    }

    public T peek() {
        return head.val;
    }

    public boolean isEmpty() {
        return head == null;
    }
}


