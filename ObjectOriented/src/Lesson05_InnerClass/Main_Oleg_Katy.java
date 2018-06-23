/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lesson05_InnerClass;

import java.util.Arrays;

/**
 *
 * @author Oleg
 */
public class Main_Oleg_Katy {

    public static void main(String[] args) {

        //error need to implements abstruct methods
        //Oleg_Katy_Ex oke = new Oleg_Katy_Ex(arr);
        int arr[] = {1, 5, 6, 4, 2, 2, 3, 4, 5};

        //קטי ירשה ממחלקה אבסטרקטית 
        // לא ניתן לבנות אוביקט ממחלקה אבסטרקטית
        // לכן קטי תממש אותה ואז נפתח בצורה המפורטת למטה
        Oleg_Katy_Ex oke = new Katy(arr);
        oke.sort();
        System.out.println(Arrays.toString(oke.arr));

        //מכיוון שלא ניתן לבנות אובייקט ממחלקה אבסטרקטית
        // אנחנו נקרא לפונקציה סטטית שהיא תממש את הממשק וישר תחזיר לנו אובייקט
        Oleg_Katy_Ex oke1 = Oleg.Get_Oleg_Katy_Ex(arr);
        oke1.sort();
        System.out.println(Arrays.toString(oke1.arr));

        //אפשר לפתוח מערך מסוג ממשק או מסוג מחלקה אבסטרקטית 
        // ולשים בתוכו את כל אלה שמימשו את הממשק 
        // ואז למשל בלולאה להפעיל לכל אחד סורט משלו וכל אחד ימיין בצורה שונה
        Oleg_Katy_Ex arr1 [] = new Oleg_Katy_Ex[34];
        arr1[0]=oke;
        arr1[1]=oke1;
        System.out.println("start for");
        for (int i = 0; i < 2; i++) {
            arr1[i].sort();
            System.out.println(Arrays.toString(arr1[i].arr));
        }
    }
}
