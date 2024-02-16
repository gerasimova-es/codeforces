package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Medium_128_LongestConsecutiveSequence {

    //[null] 8 [null] >> [8, 8]
    //[null] 7 [8, 8] >> [7, 8], [8, 7]
    //[5, 6] 7 [null] >> [5, 7], [7, 5]
    //[6, 5] 7 [8, 10] >> [5, 10], [10, 5]
    //[6, 6] 7 [8, 10] >> [6, 10], [10, 6]
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{-6, 6, -9, -7, 0, 3, 4, -2, 2, -1, 9, -9, 5, -3, 6, 1, 5, -1, -2, 9, -9, -4, -6, -5, 6, -1, 3}));
    }

    public static int longestConsecutive(int[] nums) {
        int maxLength = 0;
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if(set.contains(num)){
                continue;
            }
            set.add(num);
            Integer previous = map.getOrDefault(num - 1, num);
            Integer next = map.getOrDefault(num + 1, num);
            map.put(previous, next);
            map.put(next, previous);
            maxLength = Math.max(maxLength, next - previous + 1);
        }
        return maxLength;
    }

}
