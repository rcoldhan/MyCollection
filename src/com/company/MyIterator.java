package com.company;

import java.util.Iterator;
import java.util.NoSuchElementException;

private class MyIterator<T> implements Iterator<T> {

    int cursor = 0;

    @Override
    public boolean hasNext() {
        return cursor < size;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T next() {
        if (cursor >= size) {
            throw new NoSuchElementException();
        }
        return (T) elementData[cursor++];
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("remove");
    }
}