package Lesson11_Reflection;

public class WithPrivateFinalField {

    private int i = 1;
    private final String s = "First";
    private String s2 = "Second";

    public String toString() {
        String t = "i = " + i + ", " + s + ", " + s2;
        return t;
    }
}
