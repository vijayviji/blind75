/**
 * https://leetcode.com/problems/word-break/submissions/
 *
 * Running Time = n * n = O(n^2)
 *
 */

class Solution {
    Map<Integer, Boolean> mTbl = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet(wordDict);
        return recurse(s, set, 0);
    }
    
    private boolean recurse(String s, Set<String> wordDict, int i) {
        if (mTbl.get(i) != null) {
            return mTbl.get(i);
        }
        
        if (i == s.length()) {
            return true;
        }
        
        for (int j = i; j < s.length(); j++) {
            String substr = s.substring(i, j + 1);
            if (wordDict.contains(substr)) {
                boolean result = recurse(s, wordDict, j+1);
                mTbl.put(j+1, result);
                if (result) {
                    return true;
                }
            }
        }
        
        boolean result = false;
        mTbl.put(i, result);
        return result;
    }
}
