package leetcode;

/**
 * We are given an array of Strings. We need to find the first palindromic word and return it.
 * The palindromic is a string wich can be read same forward and backward.
 *
 * - Solution
 * To find the required string we need to iterate over each word in the array.
 * Inside the loop we define a variable with the initial value true.
 * So we assume that the word is palindromic unless we find out it is not.
 * Then we define an inner loop to access letters one by one.
 * We need complete only n/2 iterations, so we can reach the middle of the word.
 * If the chars in the symmetric positions don't equal we will set false to the variable and break. Otherwise, we continue checking chars.
 * After processing all letters we check our variable. If the value is still true we immediately return the word.
 * If we scanned all the words and didn't find any palindromic one we just return empty string.
 */
public class Easy_2108_FirstPalindromicStringInTheArray {
    public String firstPalindrome(String[] words) {
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            boolean isPolindromic = true;
            for (int j = 0; j < word.length() / 2; j++) {
                if (word.charAt(j) != word.charAt(word.length() - 1 - j)) {
                    isPolindromic = false;
                    break;
                }
            }
            if (isPolindromic) {
                return word;
            }
        }
        return "";
    }
}
