/**
 * https://leetcode.com/problems/two-sum/
 */

import java.lang.Math;

/**
 * x + y = c (c = target)
 * y = c - x. Now iterate through array substituting 'x', and search for 'y'. Searching for 'y' can be 
 * sped up by putting array in the map. As a further optimization to do this in single scan, you can add
 * elements in the map as you scan the array substituting for 'x'.
 */

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // key = num, val = index
        Map<Integer, Integer> diffLookupMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            Integer diffIdx = diffLookupMap.get(diff);
            
            if (diffIdx != null) {
                return result(i, diffIdx);
            }
            diffLookupMap.put(nums[i], i);
        }
        
        throw new RuntimeException("shouldn't reach here");
    }
    
    int[] result(int a, int b) {
        int[] result = new int[2];
        result[0] = a;
        result[1] = b;
        return result;
    }
}
