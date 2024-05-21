package leetcode;

public class Medium_45_JumpGame2 {

    public static void main(String[] args) {
        System.out.println(jump(new int[]{2, 3, 1, 1, 4}));
    }

    public static int jump(int[] nums) {
        if(nums.length < 3){
            return nums.length - 1;
        }
        int steps = 0;
        int gas = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] + i >= nums.length - 1){
                return steps + 1;
            } else if (gas < nums[i] || i == nums.length - 1) {
                steps++;
                gas = nums[i];
            }
            gas--;
        }
        return steps;
    }
}
