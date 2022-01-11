/**
 * https://leetcode.com/problems/coin-change/submissions/
 * 
 * DP with recursion (top down solution). 
 * Running Time: nCoins * Amount. (no. of subproblems = Amount, time per subproblem = nCoins)
 *
 * Very similar to knapsack problem, but items are unlimited.
 *
 */

class Solution {
    Map<Integer, Integer> memoizedTbl = new HashMap<>();
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        
        if (memoizedTbl.get(amount) != null) {
            return memoizedTbl.get(amount);
        }
        
        int minResult = Integer.MAX_VALUE;
        for (int i = coins.length - 1; i >= 0; i--) {
            int result;
            if (amount - coins[i] < 0) {
                continue;
            } else if (amount - coins[i] == 0) {
                result = 1;
            } else {
                result = coinChange(coins, amount - coins[i]);
                if (result != -1) { 
                    // if it's not -1, then we're able to use the current coin conis[i]. So we should add '1' as
                    // we're counting this coin.
                    result++;
                }
            }
            
            if (result != -1) {
                minResult = Math.min(minResult, result);
            }
        }
        
        if (minResult == Integer.MAX_VALUE) {
            minResult = -1;
        }
    
        memoizedTbl.put(amount, minResult);
        return minResult;
    }
}
