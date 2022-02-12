/* https://leetcode.com/problems/longest-substring-without-repeating-characters */

class LengthOfLongestSubstring {
  public int lengthOfLongestSubstring(String s) {
      int maxCount = 0;
      final Map<Character, Integer> map = new HashMap<>();
      
      for (int i = 0, j = 0; i < s.length(); i++) {
          if (map.containsKey(s.charAt(i))) {
              j = Math.max(j, map.get(s.charAt(i)) + 1);
          }
          
          map.put(s.charAt(i), i);
          maxCount = Math.max(maxCount, i - j + 1);
      }
      return maxCount;
 }
}

/* class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> characters = new HashSet<>();
    int i = 0, j = 0, max = 0;

    while (j < s.length()) {
      if (!characters.contains(s.charAt(j))) {
        characters.add(s.charAt(j));
        j++;
        max = Math.max(characters.size(), max);
      } else {
        characters.remove(s.charAt(i));
        i++;
      }
    }
    return max;
    }
} */
