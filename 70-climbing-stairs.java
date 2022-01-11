/**
 * https://leetcode.com/problems/climbing-stairs/submissions/
 *
 * It's fibonacci series. But I solved it without understanding this fact.
 */

class Solution {
    Map<Integer, Integer> memoizedTbl = new HashMap<>();
    public int climbStairs(int n) {
        int result = 0;
        
        if (n <= 2) {
            return n;
        }
        
        if (memoizedTbl.get(n) != null) {
            return memoizedTbl.get(n);
        }
        
        result += climbStairs(n-1);
        result += climbStairs(n-2);
        
        memoizedTbl.put(n, result);
        return result;
    }
}
