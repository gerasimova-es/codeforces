package codeforces;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Level1300_1676G_BlackWhiteTrees {

    private static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCount = scanner.nextInt();
        for (int idx = 0; idx < testCount; idx++) {
            count = 0;
            int n = scanner.nextInt();
            int[] parents = new int[n];
            for (int i = 1; i < n; i++) {
                parents[i] = scanner.nextInt();
            }
            String strColors = scanner.next();
            boolean[] colors = new boolean[n];
            for (int i = 0; i < n; i++) {
                colors[i] = strColors.charAt(i) == 'B';
            }
            Edge[] edges = build(n, parents, colors);
            calc(0, edges, new boolean[n]);
            System.out.println(count);
        }
    }

    private static Edge[] build(int n, int[] parents, boolean[] colors) {
        Edge[] edges = new Edge[n];
        for (int i = 0; i < n; i++) {
            if (edges[i] == null) {
                edges[i] = new Edge(colors[i], new HashSet<>());
            }
            if (i > 0) {
                edges[i].neighbors.add(parents[i] - 1);
                if (edges[parents[i] - 1] == null) {
                    edges[parents[i] - 1] = new Edge(colors[parents[i] - 1], new HashSet<>());
                }
                edges[parents[i] - 1].neighbors.add(i);
            }
        }
        return edges;
    }


    private static long calc(
            int vertex,
            Edge[] edges,
            boolean[] visited) {
        visited[vertex] = true;
        long diff = edges[vertex].isBlack ? 1 : -1;
        for (Integer neighbor : edges[vertex].neighbors) {
            if (!visited[neighbor]) {
                diff += calc(neighbor, edges, visited);
            }
        }
        if (diff == 0) {
            count++;
        }
        return diff;
    }

    private record Edge(boolean isBlack, Set<Integer> neighbors) {
    }
}
