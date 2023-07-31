package codeforces;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Level1500_212E_ITRestaurants {

    private static boolean[] answer;
    private static int[] sizes;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        answer = new boolean[n];
        sizes = new int[n];

        List<Integer>[] edges = new List[n];
        for (int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int vertex1 = scanner.nextInt() - 1;
            int vertex2 = scanner.nextInt() - 1;
            edges[vertex1].add(vertex2);
            edges[vertex2].add(vertex1);
        }

        calc(n, 0, -1, edges);

        int count = 0;
        for (int i = 1; i < n - 1; i++) {
            if (answer[i]) {
                count++;
            }
        }
        System.out.println(count);
        for (int i = 1; i < n - 1; i++) {
            if (answer[i]) {
                System.out.println(i + " " + (n - i - 1));
            }
        }
    }

    private static long calc(
            int n,
            int vertex,
            int parent,
            List<Integer>[] edges) {
        sizes[vertex] = 1;
        for (int neighbor : edges[vertex]) {
            if (neighbor != parent) {
                sizes[vertex] += calc(n, neighbor, vertex, edges);
            }
        }
        boolean[] options = new boolean[n];
        options[0] = true;
        for (int neighbor : edges[vertex]) {
            int size = neighbor == parent
                    ? edges.length - sizes[vertex]
                    : sizes[neighbor];
            //3, 4, 5, 7(3+4), 8(3+5), 9(4+5), 12(3+4+5)
            for (int k = n - 1; k >= 0; k--) {
                if (options[k]) {
                    options[k + size] = true;
                }
            }
        }
        for (int j = 0; j < n; j++) {
            answer[j] |= options[j];
        }

        return sizes[vertex];
    }
}
