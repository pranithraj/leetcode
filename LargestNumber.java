/* https://leetcode.com/problems/largest-number */

class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        
        String[] numsString = new String[n];
        
        for (int i = 0; i < n; i++) {
            numsString[i] = String.valueOf(nums[i]);
        }
        
        Arrays.sort(numsString, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        
        if (numsString[0].charAt(0) == '0') return "0";
        
        StringBuilder sb = new StringBuilder();
        for (String s : numsString) sb.append(s);
        
        return sb.toString();
    }
}
