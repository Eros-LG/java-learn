package org.example;

import java.text.SimpleDateFormat;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        SimpleDateFormat s1 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat s2 = new SimpleDateFormat("yyyy-MM-dd");

        System.out.println(System.identityHashCode(s1));
        System.out.println(System.identityHashCode(s2));

        System.out.println(s1 == s2);
    }
}
