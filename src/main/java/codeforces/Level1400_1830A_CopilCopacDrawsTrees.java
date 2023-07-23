package codeforces;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Level1400_1830A_CopilCopacDrawsTrees {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        for (int idx = 0; idx < count; idx++) {
            int n = scanner.nextInt();
            List<Edge>[] edges = new List[n];
            for (int i = 0; i < n; i++) {
                edges[i] = new ArrayList<>();
            }
            for (int i = 0; i < n - 1; i++) {
                int v1 = scanner.nextInt() - 1;
                int v2 = scanner.nextInt() - 1;
                edges[v1].add(new Edge(i, v2));
                edges[v2].add(new Edge(i, v1));
            }
            Queue<Edge> queue = new LinkedList<>(edges[0]);
            int[] scans = new int[n];
            scans[0] = 1;
            edges[0].forEach(edge -> scans[edge.vertex] = 1);

            int maxScan = 1;
            while (queue.size() > 0) {
                Edge edge = queue.poll();
                for (Edge next : edges[edge.vertex]) {
                    if (scans[next.vertex] == 0) {
                        scans[next.vertex] =
                                edge.order < next.order
                                        ? scans[edge.vertex]
                                        : scans[edge.vertex] + 1;
                        if (maxScan < scans[next.vertex]) {
                            maxScan = scans[next.vertex];
                        }
                        queue.add(next);
                    }
                }
            }
            System.out.println(maxScan);
        }
    }

    private record Edge(int order, int vertex) {
    }
}
