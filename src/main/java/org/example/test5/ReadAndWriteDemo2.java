package org.example.test5;

import java.io.*;
import java.nio.charset.Charset;

public class ReadAndWriteDemo2 {
    public static void main(String[] args) {
        String read_path = "src/main/java/org/example/test5/texts/java.txt";

        /**
         * 字节流转字符流
         */
        try (FileInputStream fileInputStream = new FileInputStream(read_path);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream,"utf-8")
        ) {
            //获取字符流的编码
            System.out.println(inputStreamReader.getEncoding());
            int len = 0;
            char[] data = new char[10];
            while ( (len = inputStreamReader.read(data)) != -1) {

                String s = String.valueOf(data);
                System.out.println(len + " " + s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
