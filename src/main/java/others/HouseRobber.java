package others;

public class HouseRobber {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 9, 5, 2, 7, 8, 2, 5, 5, 1, 3, 3, 3, 2, 1, 100, 4, 77, 11, 4};
        System.out.println(loop(nums));
        System.out.println(Math.max(recursion(nums, 0, 0), recursion(nums, 1, 0)));
    }

    private static int recursion(int[] nums, int position, int amount) {
        if (position >= nums.length) {
            return amount;
        }
        return nums[position] + Math.max(
                recursion(nums, position + 2, amount),
                recursion(nums, position + 3, amount)
        );
    }

    private static int loop(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int firstAmount = 0;
        int secondAmount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                firstAmount = Math.max(firstAmount + nums[i], secondAmount);
            } else {
                secondAmount = Math.max(secondAmount + nums[i], firstAmount);
            }
        }

        return Math.max(firstAmount, secondAmount);
    }

}
