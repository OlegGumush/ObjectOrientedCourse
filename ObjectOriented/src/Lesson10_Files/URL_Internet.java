package Lesson10_Files;


import java.net.*;
import java.io.*;

public class URL_Internet {//Uniform Resource Locator 

    public static void Url_1() {
        InputStream is = null;
        String fileName = new String("http://www.ariel.ac.il/");
        byte buffer[] = new byte[14000];
        try {
            is = (new URL(fileName)).openStream();
        } catch (Exception e) {
            //The constructor of URL class can throw a MalformedURLExceptio
            //and the openStream method can throw an IOException
            System.out.println("=1===>" + e);
        }
        try {
            int n = is.read(buffer, 0, buffer.length);
            System.out.println("n = " + n);
            for (int i = 0; i < n; i++) {
                System.out.print((char) buffer[i]);
            }
            System.out.println(buffer.toString());
        } catch (IOException e1) {
            System.out.println("=2===>" + e1);
        }
    }

    public static void Url_2() {
        try {
            URL urlAddress = new URL("http://www.java.sun.com");
            //URL urlAddress = new URL("http://java.sun.com");
            URLConnection connection = urlAddress.openConnection();
            InputStreamReader isr = new InputStreamReader(connection.getInputStream());
            BufferedReader instream = new BufferedReader(isr);
            String str = "1";
            while (str != null) {
                str = instream.readLine();
                System.out.println(str);
            }
        } catch (Exception e) {
            //The constructor of URL class can throw a MalformedURLExceptio
            //and the openStream method can throw an IOException
            System.out.println("=1===>" + e);
        }

    }

    public static void Url_3() {
        try {
            URL url = new URL("http://www.ariel.ac.il/images/stories/site/departments/cs/CoursesComputerScience/");
            //URL url = new URL("http://www.ariel.ac.il/");
            System.out.println("URL is: " + url.toString());
            System.out.println("protocol is: " + url.getProtocol());
            System.out.println("file name is: " + url.getFile());
            System.out.println("host is: " + url.getHost());
            System.out.println("path is: " + url.getPath());
            System.out.println("port is: " + url.getPort());
            System.out.println("default port is: " + url.getDefaultPort());
            //System.out.println("ref is: " + url.getRef());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String args[]) {
        //Url_1();
        //Url_2();
        Url_3();
    }
}
