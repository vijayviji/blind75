/**
 * https://leetcode.com/problems/3sum/
 * 
 * Use twoSum procedure. TwoSum method looks for '0' sum. But instead use it for
 * the third value in the triplet.
 *
 * Running time: O(n ^ 2). Speed can be increased by avoiding the test of 
 * isUnique() which reduces constant time, as others have done. But it makes
 * the code less readable.
 */

class Solution {
    Set<String> uniqTripletHashCodeSet = new HashSet<>();
    List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            twoSum(nums, i);
        }
        
        return result;
    }
    
    private void twoSum(int[] nums, int k) {
        int j = nums.length - 1;
        int expectedSum = -1 * nums[k];
        for (int i = k + 1; i < j; ) {
            int twoSum = nums[i] + nums[j];
            if (twoSum > expectedSum) {
                j--;
                continue;
            } else if (twoSum < expectedSum) {
                i++;
                continue;
            }
            
            List<Integer> triplet = List.of(nums[i], nums[j], nums[k]);
            if (isUnique(uniqTripletHashCodeSet, triplet)) {
                result.add(triplet);
            }
            
            j--;
            i++;
        }
    }
    
    private boolean isUnique(Set<String> uniqTripletHashCodeSet, List<Integer> triplet) {
        String hc = hashCode(triplet);
        if (uniqTripletHashCodeSet.contains(hc)) {
            return false;
        }
        
        uniqTripletHashCodeSet.add(hc);
        return true;
    }
    
    private String hashCode(List<Integer> list) {
        List<Integer> copy = new ArrayList<>(list);
        Collections.sort(copy);
        StringBuilder builder = new StringBuilder();
        for (int item : copy) {
            builder.append(item);
        }
        
        return builder.toString();
    }
}

