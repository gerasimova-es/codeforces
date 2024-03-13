package leetcode;

/**
 *
 */
public class Easy_70_ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(44)); //1 134 903 170
    }

    public static int climbStairs(int n) {
        if(n < 3) {
            return n;
        }
        int prev = 1;
        int curr = 2;
        for(int i = 2; i < n; i++){
            int temp = prev + curr;
            prev = curr;
            curr = temp;
        }
        return curr;
    }
}
