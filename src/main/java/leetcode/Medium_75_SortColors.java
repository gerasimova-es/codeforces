package leetcode;

public class Medium_75_SortColors {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        sortColors3(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public static void sortColors3(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, mid, low);
                low++;
                mid++;
            } else if (nums[mid] == 1){
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    public static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }

    public static void sortColors2(int[] nums) {
        int count0 = 0;
        int count1 = 0;
        for (int num : nums) {
            if (num == 0) {
                count0++;
            } else if (num == 1) {
                count1++;
            }
        }
        for (int i = 0; i < count0; i++) {
            nums[i] = 0;
        }
        for (int i = count0; i < count0 + count1; i++) {
            nums[i] = 1;
        }
        for (int i = count0 + count1; i < nums.length; i++) {
            nums[i] = 2;
        }
    }

    public static void sortColors1(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int x = nums[i];
            int j = i;
            while (j > 0 && nums[j - 1] > x) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = x;
        }
    }
}
