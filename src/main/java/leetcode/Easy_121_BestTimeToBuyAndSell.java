package leetcode;

/**
 * Given an array prices where each element is a price of a given stock on the ith day.
 * You want to maximaze your profit by choosing a single day to bay one stock and choosing the different day
 * to sell it.
 * Return the maximum profit you achieve from this transaction. If you cannot achieve any profit return 0;
 *
 * Solution:
 * What the question saying we need to return the maximum profit achievable from the described transaction.
 * Basically we need to find the maximum difference between price on a current day and the lowest price before.
 * So I'm going to process the given prices one by one. I need to keep track of the smallest number and check the profit
 * you can get on each step.
 * So first of all I define min variable and assign it as a price on the first day.
 * I also define result variable to store the possible profit. I set zero as initial value.
 * Then I start from the second element and iterate all the way to the end.
 * I update the min variable if the current price less than min. Otherwise, it remains the same.
 * Then I calculate the profit which I can achieve in the current position and update the result variable.
 * After all elements are processed I return the result which gives us the maximum profit.
 */
public class Easy_121_BestTimeToBuyAndSell {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int result = 0;
        for(int i = 1; i < prices.length; i++){
            min = Math.min(min, prices[i]);
            result = Math.max(result, prices[i] - min);
        }
        return result;
    }
}
