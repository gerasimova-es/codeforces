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
            calc(1, edges, counts, new boolean[n + 1]);
            int q = scanner.nextInt();
            for (int i = 0; i < q; i++) {
                System.out.println(
                        counts[scanner.nextInt()]
                                * counts[scanner.nextInt()]
                );
            }
        }
    }

    private static long calc(
            int vertex,
            List<Integer>[] edges,
            long[] counts,
            boolean[] visited) {
        visited[vertex] = true;
        long count = 0L;
        for (Integer neighbor : edges[vertex]) {
            if (!visited[neighbor]) {
                count += calc(neighbor, edges, counts, visited);
            }
        }
        count = Math.max(1, count);
        counts[vertex] = count;
        return count;
    }

}
