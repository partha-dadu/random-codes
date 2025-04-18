package com.partha.random;

import java.util.Objects;

public class Tuple<T> {
     private T first;
     private T second;

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Tuple<?> tuple = (Tuple<?>) o;
        return Objects.equals(first, tuple.first) && Objects.equals(second, tuple.second);
    }
}
