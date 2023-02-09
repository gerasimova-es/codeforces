package codeforces;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Level1000_500A_NewYearsTransport {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int cellCount = scanner.nextInt();
        int targetCell = scanner.nextInt();

        int[] a = new int[cellCount - 1];
        for (int i = 0; i < cellCount - 1; i++) {
            int value = scanner.nextInt();
            if(value < 1){
                System.out.printf("a[%d] must be in (%d, %d) interval", i, 1, cellCount - 1);
                return;
            }
            a[i] = value;
        }

        Map<Integer, Integer> p = new HashMap<>();
        for(int i = 1; i <= a.length; i++){
            p.put(i, i + a[i -1]);
        }

        Integer current = 1;
        while(current != null){
            if(current == targetCell){
                System.out.println("YES");
                return;
            }
            current = p.get(current);
        }
        System.out.println("NO");

    }
}
