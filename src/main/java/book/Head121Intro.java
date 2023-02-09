package book;

import java.util.Scanner;

public class Head121Intro {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        System.out.println(task1(a, b, c));
    }

    //groups: 123, 132, 213, 231, 312, 321
    public static int task1(int a, int b, int c) {
        if(a > b){
            a = a + b;
            b = a - b;
            a = a - b;
            System.out.printf("1) a=%d, b=%d, c=%d\n", a, b, c);
        }

        if(b > c){
            b = b + c;
            c = b - c;
            b = b - c;
            System.out.printf("2) a=%d, b=%d, c=%d\n", a, b, c);
        }

        if(a > b){
            a = a + b;
            b = a - b;
            a = a - b;
            System.out.printf("3) a=%d, b=%d, c=%d\n", a, b, c);
        }

        return b;
    }

    //6 classes:
    //1) a == b && a != c
    //2) a == b && a = c
    //etc
    public static boolean task2(int a, int b, int c, int d) {
        if(a != b){
            if(a != c){
                if(a != d){
                    if(b != c){
                        if(b != d){
                            if(c != d){
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
