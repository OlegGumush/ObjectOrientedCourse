package Lesson04_Gineric_Function;

interface Pair<K, V> {

    public K getKey();

    public V getValue();
}

class Box<T> {

    private T t;

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    public String toString() {
        return "t = " + t;
    }
}

class OrderedPair<K, V> implements Pair<K, V> {

    private K key;
    private V value;

    public OrderedPair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public String toString() {
        return "key = " + key + ", value = " + value;
    }
}

public class Generic_Interface_Pair {

    public static void main(String args[]) {
        Pair<String, Integer> p1 = new OrderedPair<String, Integer>("Cat", 8);
        Pair<String, String> p2 = new OrderedPair<String, String>("Dog", "Pedigree Dog Food (Dry)");
        
        OrderedPair<String, Integer> p3 = new OrderedPair<>("Cat", 8);
        OrderedPair<String, Box<Integer>> p = new OrderedPair<>("primes", new Box<Integer>());
        OrderedPair<String, String> p4 = new OrderedPair<>("Dog", "Pedigree Dog Food (Dry)");
        
        System.out.println(p1.toString() + ";\n" + p2.toString() + ";\n" + p3 + ";\n" + p4 + ";\n" + p + ";\n");

    }
}
