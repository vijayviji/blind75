/*
 * https://leetcode.com/problems/search-in-rotated-sorted-array/submissions/
 *
 */


class Solution {
    public int search(int[] nums, int target) {
        return find(nums, 0, nums.length - 1, target);
    }
    
    private int find(int[] nums, int startIdx, int endIdx, int target) {
        if (startIdx == endIdx) {
            return target == nums[startIdx]? startIdx : -1;
        }
        
        int mid = (startIdx + endIdx) / 2;
        
        if (target == nums[mid]) {
            return mid;
        }
        
        if (shouldSearchLeft(nums, startIdx, endIdx, mid, target)) {
            return find(nums, startIdx, mid, target);
        } else {
            return find(nums, mid + 1, endIdx, target);
        }
    }
    
    private boolean shouldSearchLeft(int[] nums, int startIdx, int endIdx, int mid, int target) {
        if (target >= nums[startIdx] && target <= nums[mid]) {
            return true;
        }
        
        if (nums[mid] < nums[startIdx] && (target >= nums[startIdx] || target <= nums[mid])) {
            return true;
        }
        
        return false;
    }
}
