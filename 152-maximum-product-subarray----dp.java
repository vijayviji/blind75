/**
 * DP Solution:
 *
 * F(i) = i * FP(i+1), if i > 0;
 * F(i) = i * FN(i+1), if i < 0;

 * FP(i) = 1, if i <= 0;
 * FP(i) = i * FP(i+1), if i > 0;
 * FP(arr.length) = 1;

 * FN(i) = 1, if i >= 0;
 * FN(i) = i * FP(i+1), if i < 0;
 * FN(arr.length) = 1;

 * max(F(i)), for i in nums
 */
    
import java.lang.Math;

class Solution {
    Map<Integer, Integer> memoizedPositiveTbl = new HashMap<>();
    Map<Integer, Integer> memoizedNegativeTbl = new HashMap<>();
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int result = 0;
            if (nums[i] > 0) {
                result = nums[i] * findMaxPositiveProduct(nums, i+1);
            } else if (nums[i] < 0) {
                result = nums[i] * findMaxNegativeProduct(nums, i+1);
            }
            
            if (result > max) {
                max = result;
            }
        }
        
        return max;
    }
    
    private int findMaxPositiveProduct(int[] nums, int startIdx) {
        Integer cachedResult = memoizedPositiveTbl.get(startIdx);
        if (cachedResult != null) {
            return cachedResult;
        }
        
        if (startIdx == nums.length || nums[startIdx] == 0) {
            memoizedPositiveTbl.put(startIdx, 1);
            return 1;
        }
        
        if (nums[startIdx] < 0) {
            int result = findMaxNegativeProduct(nums, startIdx + 1);
            if (result < 0) {
                result = result * nums[startIdx];
            }
            memoizedPositiveTbl.put(startIdx, result);
            return result;
        }
        
        int result = nums[startIdx] * findMaxPositiveProduct(nums, startIdx + 1);
        memoizedPositiveTbl.put(startIdx, result);
        return result;
    }
    
    private int findMaxNegativeProduct(int[] nums, int startIdx) {
        Integer cachedResult = memoizedNegativeTbl.get(startIdx);
        if (cachedResult != null) {
            return cachedResult;
        }
        
        if (startIdx == nums.length || nums[startIdx] == 0) {
            memoizedNegativeTbl.put(startIdx, 1);
            return 1;
        }
        
        if (nums[startIdx] > 0) {
            int result = findMaxNegativeProduct(nums, startIdx + 1);
            if (result < 0) {
                result = result * nums[startIdx];
            }
            memoizedNegativeTbl.put(startIdx, result);
            return result;
        }
        
        int result = nums[startIdx] * findMaxPositiveProduct(nums, startIdx + 1);
        memoizedNegativeTbl.put(startIdx, result);
        return result;
    }
}
