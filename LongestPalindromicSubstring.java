/* https://leetcode.com/problems/longest-palindromic-substring */

class LongestPalindromicSubstring {
    int lo, maxLen;
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        lo = 0; 
        maxLen = 0;
        
        for (int i = 0; i < s.length(); i++) {
            extendPalindrome(s, i, i); // odd length palindrome
            extendPalindrome(s, i, i + 1); // even length palindrome
        }
        return s.substring(lo, lo + maxLen);
    }
    
    private void extendPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        
        if (maxLen < right - left - 1) {
            lo = left + 1;
            maxLen = right - left - 1;
        }
    }
}
