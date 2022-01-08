import java.lang.Math;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock 
 *
 * Dynamic program solution. This can also be done in running findMax model.
 *
 * While iterating, every number is taken as buyingDay price. Then find the selling day price which is
 * the highest number from that day. Use memoization for solving overlapping sub problems.
 * 
 * The other approach is, consider every day as selling day. Then buyingDay should exist prior to that.
 * The buyingDay should be the lowest until that point. So, maintain a variable to hold running minVal.
 */
class Solution {
    private Map<Integer, Integer> memoizedTbl = new HashMap<>();
    
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int buyingDayPrice = prices[i];
            int sellingDayPrice = findMax(prices, i + 1, prices.length);
            int profit = sellingDayPrice - buyingDayPrice;
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }
    
        return maxProfit;
    }
    
    private int findMax(int[] prices, int idx_start, int length) {
        Integer memoizedVal = memoizedTbl.get(idx_start);
        if (memoizedVal != null) {
            return memoizedVal;
        }
        
        // base condition
        if (idx_start == length - 1) {
            memoizedTbl.put(idx_start, prices[idx_start]);
            return prices[idx_start];
        }
        
        int max = Math.max(prices[idx_start], findMax(prices, idx_start + 1, length));
        memoizedTbl.put(idx_start, max);
        return max;
    }
}
