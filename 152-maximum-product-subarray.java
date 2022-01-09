/**
 * https://leetcode.com/problems/maximum-product-subarray/submissions/
 *
 * Go forward & backward. Why?
 *      Cases to consider:
 *          if all nums are positive or even nums are negative, then max prod is sum of all nums.
 *          if odd num of elements are negative, then we need to run forward and backward running product, 
 *              so that we'll get product excluding one negative number which would be the highest prod.
 *          when we encounter '0', then we should reset product.
 * Non - DP Solution.
 */
    
import java.lang.Math;

class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int prod = 1; // init
        for (int i = 0; i < nums.length; i++) {
            prod = prod * nums[i];
            if (prod > max) {
                max = prod;
            }
            if (nums[i] == 0) {
                prod = 1; // reset to init value
            }
        }
        
        prod = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            prod = prod * nums[i];
            if (prod > max) {
                max = prod;
            }
            if (nums[i] == 0) {
                prod = 1; // reset to init value
            }
        }
        
        return max;
    }
}
