package codeforces;

import java.util.*;

public class Level0800_1520A_DonNotDistract {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long count = scanner.nextInt();

        Set<Character> tasks = new HashSet<>();

        for (int n = 0; n < count; n++) {
            int length = scanner.nextInt();
            String log = scanner.next();

            if (log.length() <= 2) {
                System.out.println("YES");
                continue;
            }

            tasks.clear();

            String result = "YES";

            char last = log.charAt(0);
            tasks.add(last);

            for (int i = 1; i < log.length(); i++) {
                char current = log.charAt(i);
                if (current != last) {
                    if (tasks.contains(current)) {
                        result = "NO";
                        break;
                    }
                }
                last = current;
                tasks.add(current);
            }

            System.out.println(result);

        }
    }
}
