package leetcode;

public class Medium_80_RemoveDuplicates2 {
    public int removeDuplicates(int[] nums) {
        int count = 0;
        for(int num : nums){
            nums[count] = num;
            if(count - 2 < 0 || nums[count - 2] != num){
                count++;
            }
        }
        return count;
    }
}
