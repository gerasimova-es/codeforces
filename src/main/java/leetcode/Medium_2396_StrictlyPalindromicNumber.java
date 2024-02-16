package leetcode;

public class Medium_2396_StrictlyPalindromicNumber {

    public static boolean isStrictlyPalindromic(int n) {
        for (int i = 2; i <= Math.max(2, n - 2); i++) {
            int temp = n;
            int result = 0;
            while (temp != 0) {
                result = result * i + temp % i;
                temp = temp / i;
            }
            if (result != n) {
                return false;
            }
        }
        return true;
    }
}
