/**
 * https://leetcode.com/problems/product-of-array-except-self/
 * 
 * Find productWithoutZero. Then use that only if current number (while iterating) is not zero or there's no other zero. That number
 * of course, should be divided by the self to get correct value. Some people speed up the program by not using division at all.
 */

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int productWithoutZero = 1;
        int zeroesCnt = 0;
        for (int num : nums) {
            if (num == 0) {
                zeroesCnt++;
            } else {
                productWithoutZero *= num; 
            }
        }
        
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 && zeroesCnt == 1) {
                result[i] = productWithoutZero;
            } else if (nums[i] == 0 && zeroesCnt > 1) {
                result[i] = 0;
            } else if (nums[i] != 0 && zeroesCnt >= 1) {
                result[i] = 0;
            } else {
                result[i] = productWithoutZero / nums[i];
            }
        }

        return result;
    }
}
