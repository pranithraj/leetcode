/* https://leetcode.com/problems/palindromic-substrings/ */

class PalindromicSubstrings {
    int count = 0;
    
    public int countSubstrings(String s) {
        if (s.length() < 2) return s.length();
        
        for (int i = 0; i < s.length(); i++) {
            extendPalindrome(s, i, i);
            extendPalindrome(s, i, i + 1);
        }
        return count;
    }
    
    private void extendPalindrome(String s, int low, int high) {
        while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
            low--;
            high++;
            count++;
        }
    }
}
