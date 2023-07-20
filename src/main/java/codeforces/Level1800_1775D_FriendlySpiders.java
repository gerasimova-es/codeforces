package codeforces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Level1800_1775D_FriendlySpiders {

    public static final int MAX_LEGS_COUNT = 300000;
    private static final boolean[] PRIMES = new boolean[MAX_LEGS_COUNT + 1];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] legs = new int[n];
        for (int i = 0; i < n; i++) {
            legs[i] = scanner.nextInt();
        }
        int source = scanner.nextInt() - 1;
        int destination = scanner.nextInt() - 1;

        if (source == destination) {
            System.out.printf("1\n%d", source + 1);
            return;
        }

        init();

        List<Integer>[] spiderToPrimes = new List[n];
        List<Integer>[] primeToSpiders = new List[MAX_LEGS_COUNT + 1];

        for (int i = 0; i < legs.length; i++) {
            spiderToPrimes[i] = factor(legs[i]);
            for (int prime : spiderToPrimes[i]) {
                List<Integer> spiders = primeToSpiders[prime];
                if (spiders == null) {
                    spiders = new ArrayList<>();
                    primeToSpiders[prime] = spiders;
                }
                spiders.add(i);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);

        boolean[] visited = new boolean[n];
        visited[source] = true;

        int[] parents = new int[n];
        parents[source] = -1;

        while (queue.size() > 0) {
            int spider = queue.poll();
            for (int prime : spiderToPrimes[spider]) {
                for (int neighbor : primeToSpiders[prime]) {
                    if (!visited[neighbor]) {
                        queue.add(neighbor);
                        visited[neighbor] = true;
                        parents[neighbor] = spider;
                        if (neighbor == destination) {
                            Stack<Integer> path = new Stack<>();
                            int parent = destination;
                            while (parent > -1) {
                                path.push(parent);
                                parent = parents[parent];
                            }
                            System.out.println(path.size());
                            while (!path.empty()) {
                                System.out.print((path.pop() + 1) + " ");
                            }
                            return;
                        }
                    }
                }
            }
        }
        System.out.println(-1);
    }

    public static List<Integer> factor(int number) {
        if (PRIMES[number]) {
            return List.of(number);
        }
        List<Integer> primes = new ArrayList<>();
        boolean checked;
        for (int i = 0; i * i <= number; i++) {
            if (!PRIMES[i]) {
                continue;
            }
            checked = false;
            while (number % i == 0) {
                if (!checked) {
                    primes.add(i);
                }
                number = number / i;
                checked = true;
            }
            if (PRIMES[number]) {
                primes.add(number);
                return primes;
            }
            if (number == 1) {
                return primes;
            }
        }
        return primes;
    }

    private static void init() {
        Arrays.fill(PRIMES, true);
        PRIMES[0] = false;
        PRIMES[1] = false;
        for (int i = 2; i * i < MAX_LEGS_COUNT; i++) {
            if (PRIMES[i]) {
                for (int j = i * i; j < MAX_LEGS_COUNT; j += i) {
                    PRIMES[j] = false;
                }
            }
        }
    }

}
