package book;

import java.util.Arrays;
import java.util.Iterator;

public class Head113Intro {

    public static void task1() {
        String someString = "someString";
        int result = 0;
        for (int i = 0; i < someString.length(); i++) { //N + 1 comparing, N + 1 setting
            if (Character.isLowerCase(someString.charAt(i))) { //N comparing
                result++; // maximum N setting
            }
        }
        System.out.printf("result: %d", result);
    }

    public static void task2() {
        Iterator<Integer> iterator =
                Arrays.asList(1, 2, 3, 4, 5).iterator();
        int sum = 0; //1 setting
        int count = 0; //1 setting
        while (iterator.hasNext()) { //N + 1 reading, N + 1 checking
            count++; // N setting
            sum = sum + iterator.next(); //N setting
        }
        System.out.println(sum / count);
    }

    public static void task3() {
        int a = 1;
        int b = 2;
        int c = 3;

        if (a != b && a != c && b != c) { //3 comparisons (1 class: a==b, 2 class: a==c)
            System.out.println("all of them different");
        } else {
            System.out.println("some of them are equal");
        }
    }

    //1 class a > b, 2 class a < b
    public static void task4() {
        int a = 1;
        int b = 2;
        int c = 3;

        if(a > b){
            if(a > c){
                System.out.println("a");
            } else {
                System.out.println("c");
            }
        } else {
            if(b > c){
                System.out.println("b");
            } else {
                System.out.println("c");
            }
        }
    }

    public static void task5() {

    }
}
