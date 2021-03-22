package com.company;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyCollection<E> implements Collection<E> {

    private int size;

    private Object[] elementData = new Object[10];

    @Override
    public final boolean add(final E e) {
        if (size == elementData.length) {
            elementData = Arrays.copyOf(elementData, (int) (size * 1.5f));
        }
        elementData[size++] = e;
        return true;
    }

    @Override
    public final int size() {
        return this.size;
    }

    @Override
    public final boolean isEmpty() {
        return false;
    }

    @Override
    public final Iterator<E> iterator() {
        return new MyIterator<>();
    }

    @Override
    public final boolean contains(final Object o) {
        for (int i = 0; i < size(); i++) {
            if (elementData[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public final Object[] toArray() {
        if (size() != 0) {
            return Arrays.copyOf(elementData, size());
        } else {
            return new Object[0];
        }
    }

    /**
     * возвращает все элементы коллекции в качестве T[].
     * Если переданный массив уже заполнен, то значения перепишутся.
     * Если размер переданного массива меньше размера коллекции, то
     * метод создает новый массив с типом элементов T и размером, равным размеру коллекции,
     * заполняет его элементами коллекции и возвращает.
     * Если размер массива больше размера коллекции, необходимо заменить его первые элементы
     * элементами коллекции и вернуть его.
     */
    @Override
    public <T> T[] toArray(final T[] a) {
        return null;
    }

    @Override
    public final boolean remove(final Object o) {
        Iterator<?> it = this.iterator();
        while (it.hasNext()) {
            if (it.next().equals(o)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public final boolean containsAll(final Collection<?> c) {
        boolean isContain;
        for (Object o : c) {
            isContain = false;
            for (int i = 0; i < size(); i++) {
                if (elementData[i].equals(o)) {
                    isContain = true;
                    break;
                }
            }
            if (!isContain) {
                return false;
            }
        }
        return true;
    }

    @Override
    public final boolean addAll(final Collection<? extends E> c) {
        for (E e : c) {
            if (!add(e)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public final boolean removeAll(final Collection<?> c) {
        boolean wasRemoved = false;
        for (Object o : c) {
            if (this.remove(o)) {
                wasRemoved = true;
                while (true) {
                    if (!this.remove(o)) {
                        break;
                    }
                }
            }
        }
        return wasRemoved;
    }

    @Override
    public final boolean retainAll(final Collection<?> c) {
        Iterator<?> it = this.iterator();
        boolean wasChanged = false;
        while (it.hasNext()) {
            if (!c.contains(it.next())) {
                it.remove();
                wasChanged = true;
            }
        }
        return wasChanged;
    }

    @Override
    public final void clear() {
        for (int i = 0; i < size(); i++) {
            elementData[i] = null;
            size = 0;
        }
    }

    private class MyIterator<T> implements Iterator<T> {

        private int cursor = 0;
        private int lastReturn = -1;

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
            lastReturn = cursor++;
            return (T) elementData[lastReturn];
        }

        @Override
        public void remove() {
            if (lastReturn == -1) {
                throw new IllegalStateException();
            }
            if (lastReturn < size - 1) {
                System.arraycopy(elementData, lastReturn + 1, elementData, lastReturn, size - 1 - lastReturn);
            }
            size--;
            lastReturn = -1;
            cursor--;
        }
    }
}