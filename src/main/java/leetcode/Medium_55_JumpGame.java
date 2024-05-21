package leetcode;

public class Medium_55_JumpGame {

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{3,2,1,0,4}));
    }

    public static boolean canJump(int[] nums) {
//        int closest = nums.length - 1;
//        for (int i = nums.length - 2; i >= 0; i--) {
//            if (closest - i <= nums[i]) {
//                closest = i;
//            }
//        }
//        return closest == 0;
        int max = 0;
        for (int num : nums) {
            max = Math.max(max - 1, num);
            if(max == 0){
                return false;
            }
            if (max >= nums.length) {
                return true;
            }
        }
        return max > 0;
    }
}
