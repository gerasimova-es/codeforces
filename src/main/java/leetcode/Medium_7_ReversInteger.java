package leetcode;

public class Medium_7_ReversInteger {

    //        123 == 100 + 20 + 3
//        123 mod 10 = 3;
//        0 * 10 + 3 = 3;
//        12 mod 10 = 2; ->3 * 10 + 2 = 32;
//        1 mod 10 = 1;
//        32 * 10 + 1 = 321;
    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }

    public static int reverse(int x) {
        long result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x = x / 10;
            if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
                return 0;
            }
        }
        return (int) result;
    }
}
