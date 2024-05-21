package leetcode;

public class Hard_135_Candy {

    public static void main(String[] args) {
        System.out.println(candy(new int[]{1, 3, 2, 2, 1}) == 7);
        System.out.println(candy(new int[]{1, 3, 2, 2, 1}) == 7);
        System.out.println(candy(new int[]{1, 0, 2}) == 5);
        System.out.println(candy(new int[]{1, 2, 4, 2, 1, 0}) == 5);
    }

    public static int candy(int[] ratings) {
        int lastBiggestIdx = -1;
        int result = 1;
        int reward = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                reward++;
                result += reward;
                lastBiggestIdx = i;
            } else if (ratings[i] == ratings[i - 1]) {
                reward = 1;
                result += reward;
                lastBiggestIdx = i;
            } else {
                if (reward == 1) {
                    if (lastBiggestIdx >= 0 && ratings[lastBiggestIdx] < ratings[lastBiggestIdx - 1]) { //?
                        lastBiggestIdx = lastBiggestIdx - 1;
                    }
                    result = (result + 1) + (i - lastBiggestIdx);
                } else {
                    reward = 1;
                    result += reward;
                }
            }
        }
        return result;
    }

}
