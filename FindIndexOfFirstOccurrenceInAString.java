/* https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/ */

class FindIndexOfFirstOccurrenceInAString {
    public int strStr(String haystack, String needle) {
        
        if (needle.length() > haystack.length()) return -1;
        
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                if(haystack.substring(i, i + needle.length()).equals(needle)) return i;
            }
        }
        
        return -1;
    }
    
        // Alternative approach
        public int strStr(String haystack, String needle) {
            for (int i = 0; ;i++) {
                for (int j = 0; ;j++) {
                    if (j == needle.length()) return i;
                    if (i+j == haystack.length()) return -1;
                    if (needle.charAt(j) != haystack.charAt(i + j)) break;
                }
            }
        }
}
