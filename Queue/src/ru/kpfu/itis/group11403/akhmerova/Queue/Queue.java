package ru.kpfu.itis.group11403.akhmerova.Queue;

import java.util.ArrayList;

/**
 * Created by Adelya on 21.03.2015.
 */
public class Queue<T> {

    private ArrayList<T> v;

    public Queue(int n) {
        v = new ArrayList<T>();
        for (int i = 0; i < n; i++)
            v.add(null);
    }

    int l = 0, r = 0;
    boolean flagEmpty = true, flagFull = false;

    public T popStart() {
        flagFull = false;
        int x = l;
        l = (l + 1) % v.size();
        flagEmpty = (l == r);
        return v.get(x);
    }

    public void pushEnd(T y) {
        flagEmpty = false;
        v.set(r, y);
        r = (r + 1) % v.size();
        flagFull = (r == l);
    }

    public boolean isEmpty() {
        return flagEmpty;
    }
}
