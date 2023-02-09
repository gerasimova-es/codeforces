package book;

public class Head153DivideAndConquer {

    public static void main(String[] args) {
        System.out.printf("result %d", fib(6));
    }

    private static int fib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }
}
