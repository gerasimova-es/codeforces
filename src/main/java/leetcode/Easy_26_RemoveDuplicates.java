package leetcode;

public class Easy_26_RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int position = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[position]){
                position++;
                nums[position] = nums[i];
            }
        }
        return position + 1;
    }
}
