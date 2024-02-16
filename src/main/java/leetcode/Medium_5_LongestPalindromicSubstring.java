package leetcode;

public class Medium_5_LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("tattarrattat"));
    }

    public static String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        String maxResult = String.valueOf(s.charAt(0));
        for (int i = 0; i < s.length(); i++) {
            String notEvenResult = String.valueOf(s.charAt(i));
            for (int j = i + 1; j <= Math.min(i * 2, s.length() - 1); j++) {
                if (s.charAt(j) == s.charAt(i - (j - i))) {
                    notEvenResult = s.charAt(j) + notEvenResult + s.charAt(j);
                } else {
                    break;
                }
            }
            if (maxResult.length() < notEvenResult.length()) {
                maxResult = notEvenResult;
            }

            if (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                String evenResult = "";
                for (int j = 1; j <= Math.min(i + 1, s.length() - i); j++) {
                    if (i + j >= s.length()) {
                        break;
                    }
                    char current = s.charAt(i + j);
                    if (current == s.charAt(i - j + 1)) {
                        evenResult = current + evenResult + current;
                    } else {
                        break;
                    }
                }
                if (maxResult.length() < evenResult.length()) {
                    maxResult = evenResult;
                }
            }
        }
        return maxResult;
    }

}
