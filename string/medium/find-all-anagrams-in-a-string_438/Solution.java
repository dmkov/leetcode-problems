/**

Q: What is the anagram?

"abcabaabc"
"cba"
-> "abc", "bca", "cab", "abc"

"abcabaabc"
 |.|

 'a' +1
 'b' +1
 'c' +1
 
  n=3

 Solutions:
 1. Naive: for all characters check the rest of the substring and count characters
 O(n^2)

 2. Hashmap: compute hash for the searched word and compare hashes using sliding window by adding and removing one character every time
 O(n * 26)

 3. Counter and two cursors: shift char array for number of characters from searched string. Do the same for first substring in looked string. With every match to 0, decrease counter of changes, with every new character - increase it. Every time when counter is 0 (no shifts), add index to the result. O(n)

 */

class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList();
        if (s == null || p == null || s.length() < p.length()) {
            return result;
        }
        int length = p.length(), counter = 0;
        int[] hash = new int[26];
        for (char ch : p.toCharArray()) {
            hash[ch - 'a']++;
            counter++;
        }
        
        int left = 0, right = 0;
        while (right < s.length()) {
            char end = s.charAt(right);
            if (hash[end - 'a'] >= 1) {
                counter--;
            }
            hash[end - 'a']--;
            if (counter == 0) {
                result.add(left);
            } 

            if (right - left == length - 1) {
                char start = s.charAt(left);
                if (hash[start - 'a'] >= 0) {
                    counter++;
                }
                hash[start - 'a']++;
                left++;
            }
            right++;
        }

        return result;
    }



    // public List<Integer> findAnagrams(String s, String p) {
    //     List<Integer> result = new ArrayList();
    //     if (s == null || p == null || s.length() < p.length()) {
    //         return result;
    //     }
    //     int length = p.length(); // 3
    //     int[] searched = computeHash(p);
    //     int[] hash = computeHash(s.substring(0, length));
    //     for (int i = length; i <= s.length(); i++) {
    //         int startIndex = i - length; // 0
    //         if (Arrays.equals(searched, hash)) {
    //             result.add(startIndex);
    //         }
    //         if (i < s.length()) {
    //             hash[s.charAt(startIndex) - 'a']--;
    //             hash[s.charAt(i) - 'a']++;
    //         }
    //     }
    //     return result;
    // }

    // // "cbaebabacd".  "abc"

    // private int[] computeHash(String str) {
    //     int[] hash = new int[26];
    //     for (char ch : str.toCharArray()) {
    //         hash[ch - 'a']++;
    //     }
    //     return hash;
    // }
}