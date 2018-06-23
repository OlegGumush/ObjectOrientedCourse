package Lesson05_InnerClass;

import java.util.Iterator;

public class MyVector_Inner_Iterator<T> {

    private int size;
    private final int INIT_SIZE = 10;
    private T[] data;
    ////////// iterator

    @SuppressWarnings("unchecked")
    public MyVector_Inner_Iterator() {
        size = 0;
        data = (T[]) (new Object[INIT_SIZE]);
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
    //אני ממש איטרטור וישר מחזיר אותו מחלקה פנימית ללא שם 
    public Iterator<T> iterator() {// Anonymous inner class, return Iterator 
  
        return new Iterator<T>() {
            {
                System.out.println("iterator constructor");
            }
            int i = 0;

            public boolean hasNext() {
                return i < size;
            }

            public T next() {
                return data[i++];
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
    
    public static void main(String[] args) {
        MyVector_Inner_Iterator<String> mvg = new MyVector_Inner_Iterator<String>();
        mvg.add("a");
        mvg.add("b");
        mvg.add("c");
        ////////
        System.out.println("anonim iterator:");
        Iterator<String> iterC = mvg.iterator();
        while (iterC.hasNext()) {
            System.out.print(iterC.next() + ", ");
        }
        System.out.println();
    }
}
