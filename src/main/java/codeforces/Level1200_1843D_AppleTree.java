package codeforces;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Level1200_1843D_AppleTree {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();

        for (int idx = 0; idx < count; idx++) {
            int n = scanner.nextInt();
            List<Integer>[] edges = new List[n + 1];
            for (int i = 0; i < edges.length; i++) {
                edges[i] = new ArrayList<>();
            }
            for (int i = 0; i < n - 1; i++) {
                int v1 = scanner.nextInt();
                int v2 = scanner.nextInt();
                edges[v1].add(v2);
                edges[v2].add(v1);
            }
            long[] counts = new long[n + 1];
            calc(1, -1, edges, counts);
            int q = scanner.nextInt();
            for (int i = 0; i < q; i++) {
                System.out.println(counts[scanner.nextInt()] * counts[scanner.nextInt()]);
            }
        }
    }

    private static long calc(
            int vertex,
            int parent,
            List<Integer>[] edges,
            long[] counts) {
        long count = 0;
        for (Integer neighbor : edges[vertex]) {
            if (neighbor != parent) {
                count += calc(neighbor, vertex, edges, counts);
            }
        }
        count = Math.max(1, count);
        counts[vertex] = count;
        return count;
    }

}
