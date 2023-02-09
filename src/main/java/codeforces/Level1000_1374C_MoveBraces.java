package codeforces;

import java.util.Scanner;

public class Level1000_1374C_MoveBraces {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int bundleCount = scanner.nextInt();

        int[] length = new int[bundleCount];
        String[] sequence = new String[bundleCount];

       for(int i = 0; i < bundleCount; i++){
            length[i] = scanner.nextInt();
            sequence[i] = scanner.next();
        }

       for(int i = 0; i < bundleCount; i++) {
          System.out.println(calc(sequence[i]));
       }
    }

    public static int calc(String sequence) {
        int openedCount = 0;
        int closedCount = 0;
        int change = 0;
        for(int i = 0; i < sequence.length(); i++){
            if(sequence.charAt(i) == '('){
                openedCount++;
            }
            if(sequence.charAt(i) == ')'){
                closedCount++;
            }
            if(closedCount > openedCount){
                change++;
                closedCount--;
            }
        }
        return change;
    }
}
