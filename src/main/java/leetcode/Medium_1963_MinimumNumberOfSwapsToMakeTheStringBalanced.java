package leetcode;

public class Medium_1963_MinimumNumberOfSwapsToMakeTheStringBalanced {

    public static void main(String[] args) {
        System.out.println(minSwaps("][][") == 1);
        System.out.println(minSwaps("]]][[[") == 2);
        System.out.println(minSwaps("[[][][]]][") == 1);
    }

    public static int minSwaps(String s) {
        int stackSize = 0;
        for (char c : s.toCharArray()) {
            if (c == '[') {
                stackSize++;
            } else if (stackSize > 0) {
                stackSize--;
            }
        }
        return (stackSize + 1)/2;
    }

}
