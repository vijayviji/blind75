/**
 * https://leetcode.com/problems/combination-sum-iv/
 *
 * Running Time: O(n * m). No. of subproblems = m (target). Running Time per sub problem = n.
 *
 */

class Solution {
    Map<Integer, Integer> mTbl = new HashMap<>();
    public int combinationSum4(int[] nums, int target) {
        return recurse(nums, target);
    }
    
    int recurse(int []nums, int target) {
        if (target == 0) {
            return 1;
        }
        
        if (mTbl.get(target) != null) {
            return mTbl.get(target);
        }
        
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= target) {
                result += recurse(nums, target - nums[i]);
            }
        }
        
        mTbl.put(target, result);
        return result;
    }
}
