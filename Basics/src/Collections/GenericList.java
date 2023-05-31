package Collections;

import java.util.Iterator;

//Generics list class
public class GenericList<T> implements Iterable<T>{
    private T[] nums;
    private int size;

    GenericList() {
        nums = (T[]) new Object[100];
        size = 0;
    }

    void add(T value) {
        nums[size++] = value;
    }

    void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(nums[i] + " ");
        }
    }


    @Override
    public Iterator<T> iterator() {
        return new CustomIterator<T>(this);
    }


private class CustomIterator<T> implements  Iterator<T>{

    int index = 0;
    GenericList<T> list;

    CustomIterator(GenericList<T> list){
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return index < list.size;
    }

    @Override
    public T next() {
        return list.nums[index++];
    }
}
}