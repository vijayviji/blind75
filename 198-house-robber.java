import java.lang.Math;

/**
 * https://leetcode.com/problems/house-robber/submissions/
 *
 * Running Time - O(n). No. of sub problems = n. Running Time per sub problem = 1.
 */

class Solution {
    Map<Integer, Integer> mTbl = new HashMap<>();
    public int rob(int[] nums) {
        int[] numsCopy = new int[nums.length + 2];
        numsCopy[0] = numsCopy[1] = 0;
        for (int i = 0; i < nums.length; i++) {
            numsCopy[i+2] = nums[i];
        }
        return recurse(numsCopy, 0);
    }
    
    private int recurse(int[] nums, int idx) {
        if (idx >= nums.length) {
            return 0;
        }
        
        if (mTbl.get(idx) != null) {
            return mTbl.get(idx);
        }
        
        int result;
        if (idx + 2 >= nums.length) {
            result = nums[idx];
        } else if (idx +3 >= nums.length) {
            result = nums[idx] + nums[idx+2];
        } else {
            result = Math.max(recurse(nums, idx+2), recurse(nums, idx+3)) + nums[idx];
        }
        
        mTbl.put(idx, result);
        return result;
    }
}
