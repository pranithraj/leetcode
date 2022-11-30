/* https://leetcode.com/problems/valid-anagram/ */

class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        
        int[] alphabets = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            alphabets[s.charAt(i) - 'a']++;
            alphabets[t.charAt(i) - 'a']--;
        }
        
        for (int i : alphabets) {
            if (i != 0) return false;
        }
        
        return true;
    }
}
