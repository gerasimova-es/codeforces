package codeforces;

import java.util.Scanner;

public class Level0800_71A_TooLongWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();

        String[] words = new String[count];
        for(int i = 0; i < count; i++){
            String word = scanner.next();
            if(word.length() > 10){
                word = word.charAt(0) + String.valueOf(word.length() - 2) + word.charAt(word.length() - 1);
            }
            words[i] = word;
        }

        for (String word : words) {
            System.out.println(word);
        }

    }
}
