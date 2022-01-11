/**
 * https://leetcode.com/problems/counting-bits/
 *
 * There's a pattern that repeats itself. We just need to follow the pattern.
 *
 */

class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        int[] pattern = new int[] {0, 1, 1, 2};
        for (int i = 0; i < 4 && i <= n; i++) {
            ans[i] = pattern[i];
        }
        
        int startTracker = 0;
        int endTracker = 4;
        for (int i = 4; i <= n; i++) {
            if (startTracker == endTracker) {
                startTracker = 0;
                endTracker = i;
            }
            
            ans[i] = ans[startTracker] + 1;
            startTracker++;
        }
        
        return ans;
    }
}

/**
 * Here's a more simpler solution:
    class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        for (int i=1; i<=n; i++)
            res[i] = res[i/2] + (i%2);
        return res;
    }
}
*/

/*

0
1
10
11
100
101
110
111
1000
10000
10001
10010
10011
10100
10101
10110

0
1
1
2
1
2
2
3

*/
