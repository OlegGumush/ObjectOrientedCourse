package Lesson03_Exeption_Point_Tokenaizer;

public class NullException extends Exception {

    //Where I threw a exception I have to enter the string for the constractor
    //constractor send to super -->class exeption
    public NullException(String error) {
        super(error);
    }
}
