package leetcode;

import java.util.Arrays;

/**
 * We are given two integer arrays num1 and num2 sorted in non-decreasing order and two integers m and n
 * representing the number of elements in nums1 and nums2 respectively. Merge the arrays num1 and num2 into a single
 * array in non-decreasing order.
 * The resulting arrays doesn't have to be returned by the function, but instead be stored inside the array nums1.
 * To accomodate this the num1 has a length of m + n. The first m elements must be merged and the last n elements
 * are set to 0 and should be ignored.
 *
 * Since the nums1 has a length of m + n we can use this extra space to store the merged array.
 * I am going to iterate over each array from the end and place the larger element closer to the end.
 * So I start with two pointers i and j intiliazed to m - 1 and n - 1 respectively.
 * I define a while loop which iterates until either i or j is not less than zero.
 * Inside the loop I define two while loops scanning each array. I append larger elements to the end of num1 and decrement
 * the corresponding pointer. Since I reach the beginning of num2 array I don't need to do anything
 * because the element in the nums1 are already in their correct place.
 * We will have the same situation if n equals 0;
 */
public class Easy_88_MergeSortedArray {

    public static void main(String[] args) {
        int[] first = new int[]{0};
        merge(first, 0, new int[]{1}, 1);
        System.out.println(Arrays.toString(first));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        int i = m - 1;
        int j = n - 1;
        while (i >= 0 || j >= 0) {
            while (i >= 0 && (j < 0 || nums1[i] >= nums2[j])) {
                nums1[i + j + 1] = nums1[i];
                i--;
            }
            while (j >= 0 && (i < 0 || nums1[i] < nums2[j])) {
                nums1[i + j + 1] = nums2[j];
                j--;
            }
        }
    }
}
