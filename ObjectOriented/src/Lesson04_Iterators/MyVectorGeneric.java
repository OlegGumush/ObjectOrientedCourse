package Lesson04_Iterators;

import java.util.ArrayList;
import java.util.Iterator;

public class MyVectorGeneric<T> {

    private int size;
    private final int INIT_SIZE = 10;
    private T[] data;
    ////////// iterator

    public MyIterator iterator() {
        return new MyIterator();
    }

    @SuppressWarnings("unchecked")
    public MyVectorGeneric() {
        size = 0;
        data = (T[])(new Object[INIT_SIZE]);
    }

    public void add(T value) {
        if (size == data.length) {
            resize();
        }
        data[size++] = value;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        T[] temp = (T[]) (new Object[data.length + INIT_SIZE]);
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return data.length;
    }

    public String toString() {
        String s = "[";
        for (int i = 0; i < size; i++) {
            s = s + data[i] + ", ";
        }
        s = s + "]";
        return s;
    }
    
    public class MyIterator implements Iterator<T> {

        int itCount = 0;
        boolean ifICanRemove=false;

        //×‘× ×�×™
        public MyIterator() {
            itCount = 0;
        }

        @Override
        public boolean hasNext() {
            if( itCount < size)
                return true;
            return false;
        }

        @Override
        public T next() {
            
            ifICanRemove=true;
            return data[itCount++];
        }

        @Override
        public void remove() {
            //  Iterator removes the last element returned by the iterator
            if (ifICanRemove==true) {
                //× ×ª×—×™×œ ×ž×ž×§×•×� ×©×”×�×™×˜×¨×˜×•×¨ ×¢×•×ž×“ ×¢×œ×™×• ×•× ×¢×ª×™×§ ×œ×›×œ ×�×™×‘×¨ ×�×ª ×”×”×‘×�×” ×©×œ×• ×•× ×§×˜×™×Ÿ ×�×ª ×”×’×•×“×œ ×›×�×™×œ×• ×ž×—×§× ×•
                for (int i = itCount - 1; i < size - 1; i++) {
                    data[i] = data[i + 1];
                }
                itCount--;
                size--;
                ifICanRemove=false;
            }else{
                throw new UnsupportedOperationException();
            }
        }
    }

    public static void main(String[] args) {
        
        MyVectorGeneric<String> mvg = new MyVectorGeneric<String>();
        Iterator<String> iter = mvg.iterator();
        
        ArrayList<String> arr = new ArrayList<>();
        Iterator<String> java_iter = arr.iterator();
        

        mvg.add("a");
        mvg.add("b");
        mvg.add("c");
        mvg.add("a");
        mvg.add("b");
        mvg.add("c");
        ////////
        System.out.println("iterator:");
        
        while (iter.hasNext()) {
            System.out.print(iter.next() + ", ");
        }
        
        
        System.out.println();
        iter = mvg.iterator();
        
        iter.next();
        iter.next();
        iter.next();
        iter.next();
        iter.next();

        iter.remove();
        iter.remove();
        
        iter = mvg.iterator();

        while (iter.hasNext()) {
            System.out.print(iter.next() + ", ");
        }
    }
}

