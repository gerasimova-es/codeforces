package leetcode;

import java.util.Arrays;

public class Hard_2509_CycleLengthQueriesInTree {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(cycleLengthQueries(3, new int[][]{{5, 3}, {4, 7}, {2, 3}})));
    }

    public static int[] cycleLengthQueries(int n, int[][] queries) {
        int[] results = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int from = queries[i][0];
            int to = queries[i][1];
            int count = 1;
            while (from != to) {
                if (from > to) {
                    from = from >> 1;
                } else {
                    to = to >> 1;
                }
                count++;
            }
            results[i] = count;
        }
        return results;
    }
}
