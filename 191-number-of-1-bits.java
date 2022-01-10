/**
 * https://leetcode.com/problems/number-of-1-bits/submissions/
 *
 * n & n -1 unsets right most bit in n. That way we're unsetting all 1s in 'n' and counting that. When it becomes '0', we've counted all 1s.
 * In java, there's no unsigned integer. But the input number is given in binary representation.
 *
 */
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int weight = 0;
        while (n != 0) {
            n = n & (n - 1);
            weight++;
        }
        
        return weight;
    }
}
