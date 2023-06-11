package Generics;

import java.util.Arrays;

public class DynamicArray<T> {
    private T[] array;
    private int size;
//    public DynamicArray() {
//        this.size = 0;
//        this.array = (T[]) new Object[10];
//    }
//    public DynamicArray(T[] arr) {
//        this.size = arr.length;
//        this.array = (T[]) new Object[size];
//        System.arraycopy(arr, 0, this.array, 0, size);
//    }
//    public int size() {
//        return this.size;
//    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return array[index];
    }
//    public void set(int index, T value) {
//        if(index == this.size) {
//            throw new IndexOutOfBoundsException();
//        }
//        this.array[index] = value;
//    }
    public void add(T el){
        if(size == array.length) {
//            increaseCapacity();
            array = Arrays.copyOf(array , size * 2);
        }
        array[size++] = el;
    }
    public void remove(int index) {
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;
    }
    private void increaseCapacity() {
        T[] newArray = (T[]) new Object[this.size * 2];
        System.arraycopy(this.array, 0, newArray, 0, this.size);
        this.array = newArray;
    }
}
/*    private Object[] array;
    private int size;
    private int capacity;

    public DynamicArray() {
        size = 0;
        capacity = 2;
        array = new Object[2];
    }

    public void ensureCapacity(int minCapacity) {
        Object[] temp = new Object[minCapacity * capacity];
        for (int i = 0; i < capacity; i++) {
            temp[i] = (int) array[i];
        }
        array = temp;
        capacity = capacity * minCapacity;
    }

    public void trimToSize() {
        Object[] temp = new Object[size];
        for (int i = 0; i < size; i++) {
            temp[i] = (int) array[i];
        }
        array = temp;
        capacity = array.length;
    }

    public void add(int index, T el) {
        System.arraycopy(el, index,
                el, index + 1,
                size - index);
        size++;

    }

    public T get(int index) {
        return (T) array[index];
    }

    public void remove(Object[] es, int index) {
        final int newSize;
        if ((newSize = size - 1) > index)
            System.arraycopy(es, index + 1, es, index, newSize - index);
        es[size = newSize] = null;
    }

    public int size() {
        return size;
    }


    public int capacity() {
        return capacity;
    }


    public void printElements() {
        System.out.println("elements in array are :" + Arrays.toString(array));
    }
}

 */
