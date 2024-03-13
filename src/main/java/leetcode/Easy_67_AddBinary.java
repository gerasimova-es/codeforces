package leetcode;

/**
 * What question saying is, given two strings a and b representing binary numbers.
 * We need to add these numbers and return value as a string representation.
 *
 * To get the result we need to scan through characters backward and sum up the digits on the same positions.
 * While calculation, we have to take care of the carry-over on every iteration (and also after all calculations are completed).
 *
 * So first of all we define two variables to keep track of the positions of the characters.
 * The initial value of each variable will be the length of the string minus 1.
 * To hold the carry-over between iterations we define a carry variable. We also define the result variable to keep our answer.
 *
 * We enter a while loop that iterates until we have processed all digits in both binary numbers
 * We access the characters in particular positions.
 * To obtain a numeric representation of the character we subtract code of the zero character from the code of the current digit.
 * Then we accumulate the values of both digits and decrement the indices.
 * As the sum of two digits can exceed the value 1 we calculate the remainder by division carry by 2 and append to the result.
 * Finally, we update the carry-over value by division by 2. So the quotient of this division remains for the next step.
 *
 * After all characters are processed we append the remained carry-over value to the result.
 * Then we return the reversed result which gives us the sum of the two binary numbers in binary format.
 */
public class Easy_67_AddBinary {
    public static void main(String[] args) {
        System.out.println(addBinary("1111", "1111"));
    }

    public static String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder result = new StringBuilder();
        while (i >= 0 || j >= 0) {
            if (i >= 0) {
                carry += a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                carry += b.charAt(j) - '0';
                j--;
            }
            result.append(carry % 2);
            carry = carry / 2;
        }
        if (carry > 0) {
            result.append('1');
        }
        return result.reverse().toString();
    }
}
