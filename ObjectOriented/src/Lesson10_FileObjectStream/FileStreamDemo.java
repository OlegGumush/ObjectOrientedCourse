package Lesson10_FileObjectStream;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class FileStreamDemo {

    public static void main(String args[]) {
        try {
            //output stream 
            //בשביל כתיבה
            //בקובץ חייב להיות מוכן אחרת יזרוק לנו חריזה כי לא ימצא אותו
            //אם נוסיך אמת או שקר זה יגיד לו אם להוסיף לקובץ או לדרוס
            //FileOutputStream(String fileName, boolean append);
            FileOutputStream fos = new FileOutputStream("c:\\try1.txt");
            /**
             * public void write(byte[] b) throws IOException Writes b.length
             * bytes from the specified byte array to this file output stream.
             */
            //כל דבר שאני כותב ממור לביטים
            fos.write("Hello Files!".getBytes());
            fos.write("\n123\n".getBytes());
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }    
 
        try {
            //מיועד בשביל קריאה
            //חייבים ליצור את הקובץ לפני אחרת לא ימצא אותו
            FileInputStream fis = new FileInputStream("c:\\try1.txt");
            /**
             * available() Returns: an estimate of the number of remaining bytes
             * that can be read (or skipped over) from this input stream without
             * blocking. Throws: IOException - if this file input stream has
             * been closed by calling close or an I/O error occurs.
             */
            int x = fis.available();
            System.out.println("x = " + x);
            byte vecByte[] = new byte[x];
            /**
             * public long skip(long n)throws IOException Skips over and
             * discards n bytes of data from the input stream.
             */
            int nSkip = 2;
            fis.skip(nSkip);
            /**
             * public int read(byte[] b, int off, int len) throws IOException
             * Reads up to len bytes of data from this input stream into an
             * array of bytes. If len is not zero, the method blocks until some
             * input is available; otherwise, no bytes are read and 0 is
             * returned. Parameters: b - the buffer into which the data is read.
             * off - the start offset in the destination array b len - the
             * maximum number of bytes read. Returns: the total number of bytes
             * read into the buffer, or -1 if there is no more data because the
             * end of the file has been reached.
             */
            //fis.read(vecByte,0,x-nSkip);
            //fis.read(vecByte,nSkip,x-nSkip);
            fis.read(vecByte, 0, x-5);
            System.out.println(x);
            String str = new String(vecByte);    
            System.out.println("was recieved from file :\n" + str);
            //System.out.println("was recieved from file :\n" +str.substring(0, str.length()-nSkip));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
