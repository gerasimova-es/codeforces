package codeforces;

import java.util.Scanner;
import java.util.TreeSet;

public class Level1700_1792D_PermutationWithPrefix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int bundleCount = scanner.nextInt();

        for (int c = 0; c < bundleCount; c++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            short[][] initialPerms = new short[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    initialPerms[i][j] = scanner.nextShort();
                }
            }

            TreeSet<short[]> oppositePerms = new TreeSet<>((first, second) -> {
                for (int i = 0; i < m; i++) {
                    int diff = first[i] - second[i];
                    if (diff != 0) {
                        return diff;
                    }
                }
                return 0;
            });

            for (int i = 0; i < n; i++) {
                short[] numbers = new short[m];
                for (int j = 0; j < m; j++) {
                    numbers[initialPerms[i][j] - 1] = (short) (j + 1);
                }
                oppositePerms.add(numbers);
            }

            for (int i = 0; i < n; i++) {
                //not to search twice
                short[] floor = oppositePerms.floor(initialPerms[i]);
                short[] ceiling = oppositePerms.higher(initialPerms[i]);

                int floorBeauty = 0;

                if (floor != null) {
                    for (int j = 0; j < m; j++) {
                        if (floor[j] == initialPerms[i][j]) {
                            floorBeauty++;
                        } else {
                            break;
                        }
                    }
                    if (floorBeauty == m) {
                        System.out.print(floorBeauty + " ");
                        continue;
                    }
                }
                int ceilingBeauty = 0;
                if (ceiling != null) {
                    for (int j = 0; j < m; j++) {
                        if (ceiling[j] == initialPerms[i][j]) {
                            ceilingBeauty++;
                        } else {
                            break;
                        }
                    }
                }
                System.out.print(Math.max(floorBeauty, ceilingBeauty) + " ");
            }
            System.out.println();
        }
    }
}
