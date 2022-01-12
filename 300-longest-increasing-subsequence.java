/**
 * https://leetcode.com/problems/longest-increasing-subsequence/submissions/
 *
 * Running Time = no_of_subproblems * time_per_subproblem = n * n = O(n^2) 
 *      no_of_subproblems can be found by looking at what we stored in memoizedTbl.
 *      time_per_subproblem can be found by looking at the recursion fn where a loop of 'n' is there and it runs in every sub problem.
 *
 * This can be sped up by doing bottom up approach where recursion will not be there and constant time is reduced. But running time will still be O(n^2).
 */

import java.lang.Math;

class Solution {
    Map<Integer, Integer> memoizedTbl = new HashMap<>();
    public int lengthOfLIS(int[] nums) {
        
        // prefix '-INF' in the array to ease calculations.
        int []numsCopy = new int[nums.length + 1];
        numsCopy[0] = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            numsCopy[i + 1] = nums[i];
        }
        
        return compute(numsCopy, 0) - 1;
    }
    
    private int compute(int[] nums, int idx) {
        if (idx == nums.length - 1) {
            return 1;
        }
        
        if (memoizedTbl.get(idx) != null) {
            return memoizedTbl.get(idx);
        }
        
        int max = 1;
        for (int j = idx + 1; j < nums.length; j++) {
            if (nums[j] <= nums[idx]) {
                continue;
            }
            int result = compute(nums, j) + 1;
            if (result > max) {
                max = result;
            }
        }
        
        memoizedTbl.put(idx, max);
        return max;  
    }
}
