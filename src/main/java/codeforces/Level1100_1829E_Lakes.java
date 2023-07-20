package codeforces;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Level1100_1829E_Lakes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();

        int[] results = new int[count];

        for (int idx = 0; idx < count; idx++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            int[][] lake = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    lake[i][j] = scanner.nextInt();
                }
            }

            boolean[][] visited = new boolean[n][m];
            int visitedCount = 0;

            Cell start = new Cell(0, 0);

            while (visitedCount < m * n) {
                Cell newStart = null;
                for (int i = start.x; i < n; i++) {
                    for (int j = i == start.x ? start.y : 0; j < m; j++) {
                        if (!visited[i][j]) {
                            visited[i][j] = true;
                            visitedCount++;
                            if (lake[i][j] > 0) {
                                newStart = new Cell(i, j);
                                break;
                            }
                        }
                    }
                    if (newStart != null) {
                        break;
                    }
                }
                if (newStart == null) {
                    break;
                }
                start = newStart;

                Queue<Cell> queue = new LinkedList<>();
                queue.add(start);

                int volume = 0;

                while (queue.size() > 0) {
                    Cell cell = queue.poll();
                    volume += lake[cell.x][cell.y];

                    Cell[] neighbors =
                            new Cell[]{new Cell(cell.x - 1, cell.y),
                                    new Cell(cell.x + 1, cell.y),
                                    new Cell(cell.x, cell.y - 1),
                                    new Cell(cell.x, cell.y + 1)};

                    for (Cell neighbor : neighbors) {
                        if (neighbor.x >= 0
                                && neighbor.y >= 0
                                && neighbor.x < n
                                && neighbor.y < m
                                && !visited[neighbor.x][neighbor.y]) {
                            if (lake[neighbor.x][neighbor.y] > 0) {
                                queue.add(neighbor);
                            }
                            visited[neighbor.x][neighbor.y] = true;
                            visitedCount++;
                        }
                    }
                    if (results[idx] < volume) {
                        results[idx] = volume;
                    }
                }
            }
        }
        for (int result : results) {
            System.out.println(result);
        }
    }

    private record Cell(int x, int y) {
    }

}
