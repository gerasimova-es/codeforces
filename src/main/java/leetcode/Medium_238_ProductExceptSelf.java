package leetcode;

public class Medium_238_ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        //-> 1,1,2,6
        //<- 24,12,4,1
        int n = nums.length;
        int[] result = new int[n];
        int product = 1;
        for(int i = 0; i < n; i++){
            result[i] = product;
            product *= nums[i];
        }
        product = 1;
        for(int i = nums.length - 1; i >= 0; i--){
            result[i] *= product;
            product *= nums[i];
        }
        return result;
    }
}
