/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 * 
 * When the array is rotated or not, we need to find the min element. It could be
 * either left side of the mid, or on the right side of the mid. 
 *  Draw this in picture, you'll see which side to go, based on the mid element and
 *  edge elements.
 */

import java.lang.Math;

class Solution {
    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length - 1);
    }
    
    private int findMin(int[] nums, int startIdx, int endIdx) {
        if (startIdx == endIdx) {
            return nums[startIdx];
        }
        
        if (startIdx == endIdx - 1) {
            return Math.min(nums[startIdx], nums[endIdx]);
        }
        
        int mid = (startIdx + endIdx) / 2;
        if (nums[mid] > nums[startIdx] && nums[mid] > nums[endIdx]) {
            return findMin(nums, mid + 1, endIdx);
        } else {
            return findMin(nums, startIdx, mid);
        }        
    }
}
