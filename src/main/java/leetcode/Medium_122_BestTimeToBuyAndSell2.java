package leetcode;

public class Medium_122_BestTimeToBuyAndSell2 {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{6,1,3,2,4,7}));
    }

    public static int maxProfit(int[] prices) {
        int buy = prices[0];
        int profit = 0;
        for(int price : prices){
            if(buy < price){
                profit += price - buy;
            }
            buy = price;
        }
        return profit;
    }
}
