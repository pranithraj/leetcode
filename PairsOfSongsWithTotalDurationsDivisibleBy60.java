/* https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60 */

class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int ans = 0;
        int[] c = new int[60];

        for (int t : time) {
            ans += c[(600 - t) % 60];
            c[t % 60] += 1;
        }
      
        return ans;
    }
}
