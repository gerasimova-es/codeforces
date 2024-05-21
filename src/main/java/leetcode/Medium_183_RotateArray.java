package leetcode;

public class Medium_183_RotateArray {


    public void rotateWithReverse(int[] nums, int k) {
        if(nums.length == 1 || k == 0 || k % nums.length == 0){
            return;
        }
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end){
        int n = end - start;
        for(int i = 0; i < n / 2 + 1; i++){
            int temp = nums[i + start];
            nums[i + start] = nums[end - i];
            nums[end - i] = temp;
        }
    }

    public void rotateWithTempArray(int[] nums, int k) {
        if(nums.length == 1 || k == 0 || k % nums.length == 0){
            return;
        }
        k = k % nums.length;
        int[] temp = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            temp[(i + k) % nums.length] = nums[i];
        }
        for(int i = 0; i < nums.length; i++){
            nums[i] = temp[i];
        }
    }
}
