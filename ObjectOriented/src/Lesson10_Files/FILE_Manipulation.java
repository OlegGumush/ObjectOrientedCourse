//package Lesson10_Files;
//
//import java.io.*;
////פקודות על קבצים
//public class FILE_Manipulation {
//
//    public static void fileManipulation() {
//        //הגדרת תיקיה
//        File myDir = new File("C:\\temp2");
//        //מבצעית פתיחה חוזר אמת או שקר אם הצלנו
//        boolean b = myDir.mkdir();
//        System.out.println("check if open "+b);
//        //הגדרת קובץ
//        File myFile = null;
//        try {
//            myFile = new File("C:\\temp2\\text.txt");
//            myFile.createNewFile();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        // find the parent directory (the one containing the File instance)
//        // which folder myFile exist
//        String parent = myFile.getParent();
//        System.out.println("parent: " + parent);
//        // find the absolute path of a File instance
//        // C:\temp2\text.txt נתיב איך להגיע לקובץ
//        String absolute = myFile.getAbsolutePath();
//        System.out.println("absolute: " + absolute);
//        // check if the file exists
//        boolean isThere = myFile.exists(); 
//        System.out.println("isThere: " + isThere);
//        // return all free space in disc C
//        System.out.println("getUsableSpace: " + myFile.getUsableSpace());     
//        // extract the file name
//        String name = myFile.getName();
//        System.out.println("name: " + name);
//        // the file might be a directory. We can check it by: 
//        boolean checkIfDir = myFile.isDirectory();
//        System.out.println("checkIfDir: " + checkIfDir);
//        checkIfDir = myDir.isDirectory();
//        System.out.println("checkIfDir: " + checkIfDir);
//        // get file size in bytes
//        long length = myFile.length();
//        System.out.println("length: " + length);
//        // we can fill a string array with a list of file names within a directory
//        String[] allFiles = myDir.list();
//        for (int i = 0; i < allFiles.length; i++) {
//            System.out.println((i + 1) + " file: " + allFiles[i]);
//        }
//        //check if we can read from file 
//        boolean canRead = myFile.canRead();
//        System.out.println("canRead: " + canRead);
//        //	 check if we can write to file 
//        boolean canWrite = myFile.canWrite();
//        System.out.println("canWrite: " + canWrite);
//        
//        //הגדרת תיקיה
//        File myDir1 = new File("C:\\temp2\\java");
//        //מבצעית פתיחה חוזר אמת או שקר אם הצלנו
//        myDir1.mkdir();
//        //	Atomically creates a new, empty file named by this abstract pathname 
//        //  if and only if a file with this name does not yet exist.
//        // a) the directory java does not exists
//        File newFile = new File("C:\\temp2\\java\\newFile.txt");
//        try {
//            newFile.createNewFile();
//        } catch (IOException ep) {
//            System.err.println("a) File creation is failed");
//            ep.printStackTrace();
//        }
//        // b) the directory exists
//        File newFile2 = new File("C:\\temp2\\newFile.txt");
//        try {
//            newFile2.createNewFile();
//        } catch (IOException ep) {
//            System.err.println("b) File creation is failed");
//        }
//    }
//
//    public static void main(String[] args) {
//        fileManipulation();
//    }
//}
