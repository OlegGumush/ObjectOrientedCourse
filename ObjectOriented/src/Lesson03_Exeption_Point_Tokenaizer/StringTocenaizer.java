/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lesson03_Exeption_Point_Tokenaizer;

import java.util.StringTokenizer;

/**
 * אנחנו שולחים מחרוזת לסטרינג טוקינזיר 
 * ואומרים לו לפי מה לחלק 
 * 
 */
public class StringTocenaizer {
    
    public static void main(String[] args) {
        String s = "[34,34,56,7,34,23,12]";
        String t = "oleg 319638490 katy 322006453 oleg 319638490 katy 322006453";
        StringTokenizer st= new StringTokenizer(s,"[,]");
        StringTokenizer st1= new StringTokenizer(t," ");

        int tokens = st.countTokens();
        System.out.println("count of tokens "+tokens);
        while(st.hasMoreTokens()){
            System.out.println(st.nextToken());
        }
         while(st1.hasMoreTokens()){
            System.out.print(st1.nextToken()+" ");
            System.out.println(st1.nextToken());
        }
    }
}
