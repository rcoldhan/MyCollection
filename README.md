### MyCollection
Задача дописать реализацию методов в классе **MyCollection**, реализующим интерфейс **Collection**.  
Необходимо реализовать следующие методы:  

В классе **MyIterator**:  
```java
public void remove()
```
* удалит элемент, который был в последний раз получен методом **next()**.  
Если метод **next()** еще не был вызван, возвращает **java.util.IllegalStateException**.  
Если вызвать метод **remove()** два раз подряд, возвращает **java.util.IllegalStateException**, так как элемент уже удален.  
Для корректного удаления необходимо опять вызвать метод **next()**.

В классе **MyCollection**:
```java
Object[] toArray()
```
* возвращает все элементы коллекции в качестве **Object[]**.  
```java
<T> T[] toArray(T[] a)
```
* возвращает все элементы коллекции в качестве **T[]**.  
Если переданный массив уже заполнен, то значения перепишутся.  
Если размер переданного массива меньше размера коллекции, то метод создает новый массив с типом элементов **T** и размером, равным размеру коллекции, заполняет его элементами коллекции и возвращает.  
Если размер массива больше размера коллекции, необходимо заменить его первые элементы элементами коллекции и вернуть его.  
```java
boolean remove(Object o)
```
* удалить первый элемент, равный переданному объекту (сравнение с помощью метода **equals**).  
Если такой объект найден и удален, возвращает **true**, если нет - **false**.  
```java
boolean removeAll(Collection<?> c)
```
* удалить все элементы переданной коллекции из нашей коллекции (сравнение с помощью метода **equals**).  
Если хотя бы один объект найден и удален, возвращает **true**, если нет - **false**.  
```java
boolean contains(Object o)
```
* проверяет, что такой объект содержится в коллекции (сравнение с помощью метода **equals**).  
Если такой объект найден, возвращает **true**, если нет - **false**.  
```java
boolean containsAll(Collection<?> c)
```
* проверяет, что все элементы переданной коллекции содержатся в коллекции (сравнение с помощью метода **equals**).  
Если все элементы найдены, возвращает **true**, если нет - **false**.  
```java
boolean addAll(Collection<? extends E> c)
```
* добавить все элементы переданной коллекции, если добавились, вернуть **true**. В нашем случае всегда **true**.  
```java
boolean retainAll(Collection<?> c)
```
* оставить в нашей коллекции только элементы переданной коллекции. Если коллекция осталась неизменной, вернуть **false**, иначе **true**.  
```java
void clear()
```
* очистить коллекцию.

Во время реализации **ЗАПРЕЩЕНО** использовать уже существующие реализации **Collection Framework (ArrayList, LinkedList, HashSet ...)**.

Класс реализованный на лекции:
```java
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyCollection<E> implements Collection<E> {

    private int size;

    private Object[] elementData = new Object[10];

    @Override
    public boolean add(E e) {
        if (size == elementData.length) {
            elementData = Arrays.copyOf(elementData, (int) (size * 1.5f));
        }
        elementData[size++] = e;
        return true;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator<>();
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    private class MyIterator<T> implements Iterator<T> {

        int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @Override
        @SuppressWarnings("unchecked")
        public T next() {
            if(cursor >= size){
                throw new NoSuchElementException();
            }
            return (T) elementData[cursor++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }
    }
}
```
