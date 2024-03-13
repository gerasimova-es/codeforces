package leetcode;

import java.util.Arrays;

public class Medium_2971_FindPolygon {

    public static void main(String[] args) {
        System.out.println(largestPerimeter(new int[]{1, 1, 2, 3, 5, 12, 50}) == 12);
        System.out.println(largestPerimeter(new int[]{5, 5, 50}) == -1);
        System.out.println(largestPerimeter(new int[]{1, 2, 2}) == 5);
        System.out.println(largestPerimeter(new int[]{1, 5, 1, 5}) == 12);
    }

    public static long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long result = -1;
        long sum = nums[0] + nums[1];
        for (int i = 2; i < nums.length; i++) {
            if (sum > nums[i]) {
                result = sum + nums[i];
            }
            sum += nums[i];
        }
        return result;
    }
}
