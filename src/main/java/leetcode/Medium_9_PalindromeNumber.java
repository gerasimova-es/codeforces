package leetcode;

public class Medium_9_PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(123));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int temp = x;
        int result = 0;
        while(temp != 0){
            result = result * 10 + temp % 10;
            temp = temp / 10;
        }
        return x == result;
    }
}
