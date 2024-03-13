package leetcode;

/**
 * Given an integer array sorted in non-decreasing order. Remove the duplicates from the array such that
 * each unique element appears only once in the array. The relative order of the elements must be kept the same.
 * Consider the count of unique elements of the nums as K.
 * To get accepted you need to do the following things:
 * - Change the array such that the first k elements contain the unique elements of the array in the order
 * they were represented initially. The remaining elements are not important as well as the size of the array.
 * - Return k;
 *
 * Solution:
 * As the input represents the integer array sorted in non-decreasing order we can assume that the duplicates
 * will be placed together in the array. So we just need to handle elements one by one and replace
 * repetitions with the unique elements stored close to the end of the array.
 *
 * To keep track of the count of the unique elements we need to define a position variable.
 * We set the initial value as 0 since the first element in the array is always unique and doesn't need to be changed.
 * Then we enter the loop starting from the second element.
 * We need to check whether the previous unique value and the current value are different.
 * if the considering element meets the condition we increment the position variable by 1
 * and update the element in the position with the new unique one.
 * By doing this, we effectively overwrite any duplicates in the array and only keep the unique elements.
 *
 * Once the loop finishes, the position value plus one represents the length of the resulting array with duplicates removed.
 */
public class Easy_36_RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1, 1, 2}));
    }

    public static int removeDuplicates(int[] nums) {
        int position = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[position]){
                nums[++position] = nums[i];
            }
        }
        return position + 1;
    }
}
