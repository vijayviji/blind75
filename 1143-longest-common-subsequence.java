import java.lang.Math;
/**
 * https://leetcode.com/problems/longest-common-subsequence/submissions/
 *
 * Running time: O(m * n), m = text1.length(), n = text2.length(). In each sub problem, we're checking one char in text 1
 *  against another char in text 2. So there are m * n sub problems. Each execution of sub problem takes constant time.
 *
 * Though this is faster, the bottom up solution is much faster in leetcode, but that is also O(m * n).
 *
 */

class Solution {
    Map<String, Integer> memoizedTbl = new HashMap<>();
    public int longestCommonSubsequence(String text1, String text2) {
        int result = recurse(text1, 0, text2, 0);
        return result;
    }
    
    private int recurse(String text1, int idx1, String text2, int idx2) {
        if (idx1 == text1.length() || idx2 == text2.length()) {
            return 0;
        }
        
        String hash = idx1 + "," + idx2;
        if (memoizedTbl.get(hash) != null) {
            return memoizedTbl.get(hash);
        }
        
        int result;
        if (text1.charAt(idx1) == text2.charAt(idx2)) {
            result = recurse(text1, idx1+1, text2, idx2+1) + 1;
        } else {
            result = Math.max(recurse(text1, idx1, text2, idx2+1), recurse(text1, idx1+1, text2, idx2));
        }
        
        memoizedTbl.put(hash, result);
        return result;
    }
}
