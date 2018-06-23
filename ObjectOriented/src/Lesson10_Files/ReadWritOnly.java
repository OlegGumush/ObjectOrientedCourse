package Lesson10_Files;

import java.io.*;

public class ReadWritOnly {

    public static void writeFile(String fileName) {
        //try write to the file
        try {
            /**
             * public FileWriter(String fileName, boolean append) throws
             * IOException Constructs a FileWriter object given a file name with
             * a boolean indicating whether or not to append the data written.
             * Parameters: fileName - String The system-dependent filename.
             * append - boolean if true, then data will be written to the end of
             * the file rather than the beginning. FileWriter is meant for
             * writing streams of characters. For writing streams of raw bytes,
             * consider using a FileOutputStream. *
             */
            //BufferedWriter = PrintWriter
            FileWriter fw = new FileWriter(fileName);
            PrintWriter outs = new PrintWriter(fw);
            outs.println("the first string: java, C++ ");
            outs.println("the second string: geometria analitit");
            outs.println("the third  string, other new string");
            outs.println("the fourth string");
            outs.close();
            fw.close();
        } catch (IOException ex) {
            System.out.print("Error writing file\n" + ex);
        }
    }

    public static void readFile(String fileName) {
        //		 try read from the file
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String str;
            str = br.readLine();
            System.out.println(0 + ") " + str);
            for (int i = 1; str != null; i = i + 1) {
                str = br.readLine();
                if (str != null) {
                    System.out.println(i + ") " + str);
                }
            }
            br.close();
            fr.close();
        } catch (IOException ex) {
            System.out.print("Error reading file\n" + ex);
            System.exit(2);
        }
    }

    public static void consoleRead() {
        BufferedReader keyboard;
        String s = "a";
        System.err.println("get line");
        keyboard = new BufferedReader(new InputStreamReader(System.in));
        int i = 0;
        while (!s.equals("")) {
            try {
                s = keyboard.readLine();
            } catch (IOException e) {
                System.err.println("error");
            }
            System.err.println(s);
            i++;
        }
    }

    public static void consolePrint() {
        PrintWriter outs = new PrintWriter(System.out);
        outs.println("the first string: java, C++ ");
        outs.println("the second string: geometria analitit");
        outs.println("the third  string, other new string");
        outs.println("the fourth string");
        outs.close();
    }
//open in scr folder
    public static void main(String[] args) {
		String name = "Oleg.txt";
		writeFile(name);
		readFile(name);
		consolePrint();
        consoleRead();
    }
}
