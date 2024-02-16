package leetcode;

//Example 1:
//
//        Input: s = "PAYPALISHIRING", numRows = 3
//        Output: "PAHNAPLSIIGYIR"
//        Example 2:
//
//        Input: s = "PAYPALISHIRING", numRows = 4
//        Output: "PINALSIGYAHRPI"
//        Explanation:
//        P     I    N
//        A   L S  I G
//        Y A   H R
//        P     I
//1, (6)7, (6)13
//2, (4)6, (2)8, (4)12, (2)14
//3, (2)5, (4)9, (2)11,
//4, (6)10

//        P       I      N
//        A     S I     G
//        Y   P   H   R
//        P P     I I
//        P       I
//1, (8)9, (8)17
//2, (6)8, (2)10, (6)16,
//3, (4)7, (4)11, (4)15

public class Medium_6_ZigZagConversation {

    public static void main(String[] args) {
        if (convert2("PAYPALISHIRING", 3).equals("PAHNAPLSIIGYIR")) {
            System.out.println("correct");
        } else {
            System.out.println("incorrect");
        }
    }

    public static String convert2(String string, int numRows) {
        if (numRows == 1) {
            return string;
        }
        StringBuilder result = new StringBuilder();
        int bigStep = numRows * 2 - 2;
        for (int i = 0; i < numRows; i++) {
            int index = i;
            while (index < string.length()) {
                result.append(string.charAt(index));
                if (i != 0 && i != numRows - 1) {
                    int middleStep = bigStep - 2 * i;
                    if (index + middleStep < string.length()) {
                        result.append(string.charAt(index + middleStep));
                    }
                }
                index += bigStep;
            }
        }
        return result.toString();
    }
}
