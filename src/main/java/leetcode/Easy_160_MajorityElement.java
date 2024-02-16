package leetcode;

import java.util.Arrays;

/**
 * Given an array of length n. You need to Find the majority element.
 * The majority element appears more the half times in the array.
 * You may assume that the majority element always exists in the array.
 *
 * - Solution
 * There is a special solution for solving this problem. It is called Boyer-Moore Majority Vote Algorithm.
 * At first, I need to pick up the first element as a possible answer. I also have a counter with the initial value equals 1.
 * Then I am going forward and if the next value equals the saved one I increment the counter. Otherwise, I need to decrement it.
 * If at any time I have count zero I assign my current number as an answer and reset the counter to 1.
 * After all iterations I just need to return answer variable
 */
public class Easy_160_MajorityElement {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
