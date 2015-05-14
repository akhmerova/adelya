package ru.kpfu.itis.group11403.akhmerova.Stack;

/**
 * Created by Adelya on 10.04.2015.
 */

public class MyStack<T> {
    @SuppressWarnings("hiding")
    class Elem<T> {
        T val;
        Elem<T> next;
    }

    int s;

    private Elem<T> head;

    public MyStack() {
        this.head = null;
        this.s = 0;
    }

    public void add(T x) {
        Elem<T> p = new Elem<T>();
        p.val = x;
        p.next = this.head;
        this.head = p;
        this.s++;
    }

    public T delete() {
        if (!this.isEmpty()) {
            T x = this.head.val;
            this.head = this.head.next;
            this.s--;
            return x;
        }
        return null;
    }

    public int size() {
        return s;
    }

    public T peek() {
        return this.head.val;
    }

    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public String toString() {
        String result = "";
        if (!this.isEmpty()) {
            MyStack st1 = this;
            Elem<T> el1;
            while (!st1.isEmpty()) {
                result += (st1.head.val) + " | ";
                st1.delete();
            }
        }
        return result;
    }
}
