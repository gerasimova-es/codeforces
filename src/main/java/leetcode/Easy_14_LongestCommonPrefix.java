package leetcode;

public class Easy_14_LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"ab", "a"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (i < strs[0].length()) {
            char letter = strs[0].charAt(i);
            for (String str : strs) {
                if (str.length() <= i) {
                    return stringBuilder.toString();
                }
                if (str.charAt(i) != letter) {
                    return stringBuilder.toString();
                }
            }
            stringBuilder.append(letter);
            i++;
        }
        return stringBuilder.toString();
    }
}
