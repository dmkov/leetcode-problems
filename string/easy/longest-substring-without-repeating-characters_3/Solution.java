/**

"abcaabcda" -> 4
     s
      e
 ___
  ___
     ____
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int start = 0, end = 0, max = 0;
        Set<Character> set = new HashSet();
        while (end < s.length()) {
            if (!set.contains(s.charAt(end))) {
                set.add(s.charAt(end));
                end++;
            } else {
                set.remove(s.charAt(start));
                start++;
            }
            max = Math.max(max, end - start);
        }
        return max;
    }
}