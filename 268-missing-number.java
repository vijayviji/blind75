/*
 * https://leetcode.com/problems/missing-number/submissions/
 */

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }
        
        int missingNum = expectedSum - actualSum;
        return missingNum;
    }
}
