/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lesson10_Files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Oleg
 */
public class File extends JFrame {

    public void ReadFile() {
        String name = "t.txt";
        FileReader fr = null;
        BufferedReader br = null;
        try {
            //()--> file or String file name
            fr = new FileReader(name);
            br = new BufferedReader(fr);
            String s;
            while ((s = br.readLine()) != null) {
                System.out.println(s);
            }
            br.close();
            fr.close();
            

        } catch (FileNotFoundException ex) {
            Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void WriteFile() {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            //FileWriter(name , true/false)
            //true - write to the end of file
            fw = new FileWriter("t.txt",true);
            bw = new BufferedWriter(fw);
            bw.write("\noooppphhh\n");
            //buffer close first or we get exeption why?!?!?!
            bw.close();
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    public static void main(String[] args) {
        File f = new File();
        f.ReadFile();
        f.WriteFile();
        f.ReadFile();

    }
}
