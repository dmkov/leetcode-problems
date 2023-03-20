/**
121. Best Time to Buy and Sell Stock
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

 
Example 1:
Input: prices = [7,1,5,3,6,4]
Output: 5

Example 2:
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.

Q: Can I buy and sell multiple times? 
- No

Is it always an integer array? No negative numbers?
- Yes

What to return if no profit?
- 0

Solutions:
1. Brute force. For every number check all foolowing numbers
O(n^2)

2. Get array with max values after the index (right side)
Iterate array from the left, for every number -> check the difference. Get the max.
O(n) with O(n) space

[7,1,5,3,6,4]
[7,6,6,6,6,4]

*/
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            throw new IllegalArgumentException();
        }

        int[] highs = new int[prices.length];
        highs[highs.length - 1] = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            highs[i] = Math.max(prices[i], highs[i + 1]);
        }

        int maxProfit = 0;
        for (int i = 0; i < highs.length - 1; i++) {
            maxProfit = Math.max(maxProfit, highs[i+1] - prices[i]);
        }
        return maxProfit;
    }
}