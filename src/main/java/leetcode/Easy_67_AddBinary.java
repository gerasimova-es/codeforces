package leetcode;

public class Easy_67_AddBinary {
    public static void main(String[] args) {
        System.out.println(addBinary("1111", "1111"));
    }

    public static String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
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
