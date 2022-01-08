import java.lang.Math;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 * This solution uses divide and conquer strategy and solves in O(n log n) time better than O(n^2).
 */
class Solution {
    public int maxProfit(int[] prices) {
        int result = recurse(prices, 0, prices.length - 1);
        if (result < 0) {
            return 0;
        }
        
        return result;
    }
    
    private int recurse(int[] prices, int idx_start, int idx_end) {
        if (idx_start == idx_end) { // base condition: same day you can't buy and sell.
            return 0;
        }
        
        int mid = (idx_start + idx_end) / 2;
        int leftMaxProfit = recurse(prices, idx_start, mid);
        int rightMaxProfit = recurse(prices, mid + 1, idx_end);
        
        int leftMin = find_min(prices, idx_start, mid);
        int rightMax = find_max(prices, mid + 1, idx_end);
        int crossingMaxProfit = rightMax - leftMin;
        
        return Math.max(Math.max(leftMaxProfit, rightMaxProfit), crossingMaxProfit);
    }
    
    private int find_min(int[] nums, int idx_start, int idx_end) {
        int min = nums[idx_start];
        for (int i = idx_start; i <= idx_end; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        
        return min;
    }
    
    private int find_max(int[] nums, int idx_start, int idx_end) {
        int max = nums[idx_start];
        for (int i = idx_start; i <= idx_end; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        
        return max;
    }
}
