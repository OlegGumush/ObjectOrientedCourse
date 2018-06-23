package Lesson04_Gineric_Function;

import java.util.ArrayList;
import java.util.List;

public class Gineric_Function_Amount_Variables {

    /**
     * Method using variable-length argument list
     *
     * @param <T>
     * @param args
     */
    @SafeVarargs
    public static <T> ArrayList<T> makeAList(T... args) {
        ArrayList<T> argList = new ArrayList<T>();
        for (T t : args) {
            argList.add(t);
        }
        return argList;
    }

    public static void fun(int... Alot_num) {
        for (int temp : Alot_num) {
            System.out.print(temp + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a1 = {1, 2, 3};
        fun(a1);
        fun(4, 5, 6, 7, 8, 9);
        fun(4, 5);
        /////
        List<String> list1 = makeAList("One", "Two", "Three");
        List<String> list2 = makeAList("One", "Two", "Three", "Four");
        
        List<Integer> list3 = makeAList(2, 4, 5, 6, 7, 8, 9);
        List<Double> list4 = makeAList(2.5, 3.14);
        
        
                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
        System.out.println(list1);
        System.out.println(list2);
        System.out.println(list3);
        System.out.println(list4);
        System.out.println();
        fun(1, 2, 3);
        fun(1, 1, 2, 3, 5, 8, 13, 21);
        
System.out.printf("%s\n","abc");
    }
}
