/**
 * https://leetcode.com/problems/container-with-most-water/submissions/
 *
 * Left pointer and Right pointer technique ->
 *   https://www.youtube.com/watch?v=UuiTKBwPgAo
 */

import java.lang.Math;

class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int maxArea = Math.min(height[l], height[r]) * (r - l);
        while (l < r) {
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
            
            int area = Math.min(height[l], height[r]) * (r - l);
            if (area > maxArea) {
                maxArea = area;
            }
        }
        
        return maxArea;
    }
}
