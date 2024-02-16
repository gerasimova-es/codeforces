package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Medium_3_LongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abba"));
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastPositions = new HashMap<>();
        char[] chars = s.toCharArray();
        int currentResult = 0;
        int maxResult = 0;
        for (int i = 0; i < chars.length; i++) {
            if (lastPositions.containsKey(chars[i])) {
                currentResult = Math.min(i - lastPositions.get(chars[i]), currentResult + 1);
            } else {
                currentResult++;
            }
            lastPositions.put(chars[i], i);
            maxResult = Math.max(currentResult, maxResult);
        }
        return maxResult;
    }
}
