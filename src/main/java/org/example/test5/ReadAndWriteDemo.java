package org.example.test5;

import java.io.*;

public class ReadAndWriteDemo {
    public static void main(String[] args) {
        readBinaryFile();

        readTextFile();
    }

    public static void readBinaryFile() {
        String read_path = "src/main/java/org/example/test5/images/java_io.png";
        String save_path = "src/main/java/org/example/test5/images/java_io_copy.png";

        try (FileInputStream inputStream = new FileInputStream(read_path);
             FileOutputStream outputStream = new FileOutputStream(save_path)
        ) {
            int len = 0;
            byte[] data = new byte[1024];
            while ((len = inputStream.read(data)) != -1) {
                System.out.println(len);
                outputStream.write(data,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readTextFile() {
        String read_path = "src/main/java/org/example/test5/texts/java.txt";
        String save_path = "src/main/java/org/example/test5/texts/java_copy.txt";

        try (FileReader fileReader = new FileReader(read_path);
             FileWriter fileWriter = new FileWriter(save_path);
        ) {
            int len = 0;
            char[] data = new char[10];
            while ( (len = fileReader.read(data)) != -1) {

                String s = String.valueOf(data);
                System.out.println(len + " " + s);
                fileWriter.write(data,0,len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
