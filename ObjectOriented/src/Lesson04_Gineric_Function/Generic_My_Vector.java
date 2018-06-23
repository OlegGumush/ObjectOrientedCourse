package Lesson04_Gineric_Function;

import java.util.Arrays;

public class Generic_My_Vector<T> {
	private int count;
	private final int INIT_SIZE = 10;
	private T [] data;
	////////// iterator
	
	@SuppressWarnings("unchecked")
	public Generic_My_Vector(){
		count = 0;
		data = (T [])(new Object[INIT_SIZE]);
		//data = new T[INIT_SIZE]; ERROR!
	}
	public void add(T value){
		if (count == data.length) resize();
		data[count++] = value;
	}
	@SuppressWarnings("unchecked")
	private void resize(){
		T [] temp = (T [])(new Object[data.length+INIT_SIZE]);
		for (int i = 0; i<data.length; i++){
			temp[i] = data[i];
		}
		data = temp;
	}
	public int size(){return count;}
	
	public T elementAt(int i){
		return data[i];
	}
	public int capacity(){return data.length;}
	
	public String toString(){
		String s = "[";
		for (int i = 0; i<count; i++){
			s = s + data[i] + ", ";
		}
		s  = s + "]";
		return s;
	}
        public void sort(){
            T [] temp = (T [])(new Object[count]);
            temp = Arrays.copyOf(data, count);
            Arrays.sort(temp);
            for(int i=0; i<temp.length; i++){
               data[i] = temp[i];
            }
            System.out.println("data.len = "+data.length);
        }
        public static <T> boolean f(T x, T y){
            return x.equals(y);
        }
	/////////////// MyIterator
	public static void main(String[] args) {
		Generic_My_Vector<String> mvg = new Generic_My_Vector<String>();
		mvg.add("abc");
		mvg.add("to be or to eat");
		mvg.add("I love Java");
		mvg.add("Hello World");
		System.out.println(mvg.toString());
		//////////
		Generic_My_Vector<Integer> mvgInt = new Generic_My_Vector<Integer>();
		mvgInt.add(5);
		mvgInt.add(2);
		mvgInt.add(13);
		mvgInt.add(4);
		System.out.println(mvgInt.toString());
                mvgInt.sort();
		System.out.println(mvgInt.toString());
		/////////
		Generic_My_Vector<Character> mvgObj = new Generic_My_Vector<Character>();
		mvgObj.add('a');
		mvgObj.add('b');
		mvgObj.add('c');
		System.out.println(mvgObj.toString());
		//////////////////
	}

}
