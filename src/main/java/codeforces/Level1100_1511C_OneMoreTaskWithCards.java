package codeforces;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Level1100_1511C_OneMoreTaskWithCards {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();

        List<Integer> cards = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            cards.add(scanner.nextInt());
        }

        int[] colors = new int[q];
        for (int i = 0; i < q; i++) {
            colors[i] = scanner.nextInt();
        }

        int[] positions = execute(cards, colors);
        for (int i : positions) {
            System.out.print(i + " ");
        }
    }

    private static int[] execute(List<Integer> cards, int[] colors) {
        int[] positions = new int[colors.length];
        for (int i = 0; i < colors.length; i++) {
            int position = cards.indexOf(colors[i]);
            positions[i] = position + 1;
            cards.remove(position);
            cards.add(0, colors[i]);
        }
        return positions;
    }

}
