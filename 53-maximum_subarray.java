/**
 * https://leetcode.com/problems/maximum-subarray/
 *
 * This problem can be solved via dynamic programming or running sum.
 * Dynamic programming: f(i) = max(currentNum, currentNum + f(i+1)); f(arr.length - 1) = max(0, arr[arr.length - 1]);
 *
 */
import java.lang.Math;
class Solution {
    public int maxSubArray(int[] nums) {
        int maxVal = Integer.MIN_VALUE;
        int runningSum = 0;
        for (int num : nums) {
            runningSum = Math.max(num, runningSum + num);
            maxVal = Math.max(maxVal, runningSum);
        }
        
        return maxVal;
    }
}
